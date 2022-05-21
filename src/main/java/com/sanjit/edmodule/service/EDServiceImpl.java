package com.sanjit.edmodule.service;

import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sanjit.edmodule.entity.ApplicantDetails;
import com.sanjit.edmodule.entity.CoTriggerEntity;
import com.sanjit.edmodule.entity.DCChildEntity;
import com.sanjit.edmodule.entity.DCEducation;
import com.sanjit.edmodule.entity.DCIncome;
import com.sanjit.edmodule.entity.DCPlans;
import com.sanjit.edmodule.entity.EDDetailsTb;
import com.sanjit.edmodule.repository.ARRepository;
import com.sanjit.edmodule.repository.ChildRepo;
import com.sanjit.edmodule.repository.CoTriggerRepository;
import com.sanjit.edmodule.repository.EDModuleRepo;
import com.sanjit.edmodule.repository.EducationRepo;
import com.sanjit.edmodule.repository.IncomeRepo;
import com.sanjit.edmodule.repository.PlansRepo;

@Service
public class EDServiceImpl implements EDService {
	@Autowired
	PlansRepo repo;
	@Autowired
	ARRepository arrepo;
	@Autowired
	IncomeRepo incomeRepo;
	@Autowired
	EDModuleRepo edRepo;
	@Autowired
	EducationRepo educationRepo;
	@Autowired
	ChildRepo childRepo;
	@Autowired
	CoTriggerRepository cotrigrepo;

	@Override
	public EDDetailsTb plans(Integer cnum) {
		DCPlans plan = repo.findByCaseNumber(cnum).orElse(null);
		ApplicantDetails details = arrepo.findById(cnum).orElse(null);
		
		EDDetailsTb edDetails = new EDDetailsTb();
		edDetails.setCaseNum(cnum);
		edDetails.setHolderName(details.getFullName());
		edDetails.setHolderSSn(details.getSsn());
		DCIncome income = incomeRepo.findByCaseNumber(cnum).orElse(null);
		DCEducation education = educationRepo.findByCaseNumber(cnum).orElse(null);
		List<DCChildEntity> children = childRepo.findByCaseNumber(cnum);

		if (plan.getPlanName().equals("SNAP")) {
			edDetails.setPlanName("SNAP");
			if (income.getSalaryIncome() <= 300) {
				edDetails.setPlanStatus("Approved");
				Calendar calendar = Calendar.getInstance();
				calendar.add(Calendar.MONTH, 1);
				calendar.set(Calendar.DATE, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
				edDetails.setStartDate(calendar.getTime());
				calendar.add(Calendar.MONTH, 3);
				edDetails.setEndDate(calendar.getTime());
				edDetails.setBenefitAmt(300.0);
			} else {
				edDetails.setPlanStatus("Denied");
				edDetails.setBenefitAmt(0.0);
				edDetails.setDenialReason("High income");

			}

		} else if (plan.getPlanName().equals("Medicaid")) {
			edDetails.setPlanName("Medicaid");
			if (income.getSalaryIncome() <= 300 && income.getPropertyIncome() == 0) {
				edDetails.setPlanStatus("Approved");
				Calendar calendar = Calendar.getInstance();
				calendar.add(Calendar.MONTH, 1);
				calendar.set(Calendar.DATE, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
				edDetails.setStartDate(calendar.getTime());
				calendar.add(Calendar.MONTH, 3);
				edDetails.setEndDate(calendar.getTime());
				edDetails.setBenefitAmt(300.0);
			} else {
				edDetails.setPlanStatus("Denied");
				edDetails.setBenefitAmt(0.0);
				edDetails.setDenialReason("High salary or property income");
			}
		
		}
		else if (plan.getPlanName().equalsIgnoreCase("NJW")) {
			edDetails.setPlanName("NJW");
			if (education.getGraduationStatus().equalsIgnoreCase("graduate") 
					&& income.getSalaryIncome() == 0) 
			  {
				edDetails.setPlanStatus("Approved");
				Calendar calendar = Calendar.getInstance();
				calendar.add(Calendar.MONTH, 1);
				calendar.set(Calendar.DATE, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
				edDetails.setStartDate(calendar.getTime());
				calendar.add(Calendar.MONTH, 3);
				edDetails.setEndDate(calendar.getTime());
				edDetails.setBenefitAmt(400.0);
			} else {
				edDetails.setPlanStatus("Denied");
				edDetails.setBenefitAmt(0.0);
				edDetails.setDenialReason("not graduate or already employed");
			}
		}
		
          else if (plan.getPlanName().equalsIgnoreCase("Medicare")) {
			edDetails.setPlanName("Medicare");
			LocalDate today = LocalDate.now(); 
            LocalDate birthday = details.getDob(); 
            Period p = Period.between(birthday, today);
           
              if(  p.getYears()>=65)
              {
      				edDetails.setPlanStatus("Approved");
      				Calendar calendar = Calendar.getInstance();
      				calendar.add(Calendar.MONTH, 1);
      				calendar.set(Calendar.DATE, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
      				edDetails.setStartDate(calendar.getTime());
      				calendar.add(Calendar.MONTH, 3);
      				edDetails.setEndDate(calendar.getTime());
      				edDetails.setBenefitAmt(600.0);
             }
            	  else {
      				edDetails.setPlanStatus("Denied");
      				edDetails.setBenefitAmt(0.0);
      				edDetails.setDenialReason("age less than 65");
      			}	  
			
		}


   
		else if (plan.getPlanName().equalsIgnoreCase("CCAP")) {
			edDetails.setPlanName("CCAP");
			boolean flag = false;;
			if (income.getSalaryIncome() <= 300 && children.size() >= 1) {
				flag=true;
				for (DCChildEntity child : children) {
					if (child.getChildAge() > 16)
					{
						flag = false;
					}
				}
			}
				if (flag == true) {
					edDetails.setPlanStatus("Approved");
					Calendar calendar = Calendar.getInstance();
					calendar.add(Calendar.MONTH, 1);
					calendar.set(Calendar.DATE, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
					edDetails.setStartDate(calendar.getTime());
					calendar.add(Calendar.MONTH, 3);
					edDetails.setEndDate(calendar.getTime());
					edDetails.setBenefitAmt(600.0);
				}
			
			else {
				edDetails.setPlanStatus("Denied");
				edDetails.setBenefitAmt(0.0);
				edDetails.setDenialReason("higher income or child age >16");
			}
		}
		else {}
		 
		

		edRepo.save(edDetails);
		CoTriggerEntity cotrigentity = new CoTriggerEntity();
		cotrigentity.setCaseNumber(cnum);
		cotrigentity.setCoPdf(null);
		cotrigentity.setTrgStatus("pending");
		cotrigrepo.save(cotrigentity);
		
		
		

		return edDetails;
	}

}
