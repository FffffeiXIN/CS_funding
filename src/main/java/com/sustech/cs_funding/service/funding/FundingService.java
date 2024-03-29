package com.sustech.cs_funding.service.funding;

import com.sustech.cs_funding.common.Result;
import com.sustech.cs_funding.entity.*;
import com.sustech.cs_funding.entity._ExpenditureSummary;
import com.sustech.cs_funding.entity._ExpenditureSummaryUser;
import com.sustech.cs_funding.entity._MultiUsedTable;
import com.sustech.cs_funding.entity.GroupFund;
import com.sustech.cs_funding.entity.ResearchGroup;
import com.sustech.cs_funding.mapper.FundingMapper;
import com.sustech.cs_funding.mapper.ResearchGroupMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class FundingService {
    @Autowired
    FundingMapper fundingMapper;

    @Autowired
    ResearchGroupMapper researchGroupMapper;

    public Result getFundingInfo(String funding, String group) {
        GroupFund groupFund = fundingMapper.selectFunding(group, funding);
        HashMap<String, Double> res = new HashMap<>();
        res.put("total", groupFund.getTotal());
        res.put("used", groupFund.getUsed());
        res.put("rest", groupFund.getTotal() - groupFund.getUsed());
        return Result.ok().code(200).message("Success").addData("funding_info", res);
    }

    public Result getFunding() {
        return queryFunding(null);
    }

    public Result queryFunding(String groupName) {
        List<ResearchGroup> groups;
        if (groupName == null) {
            groups = researchGroupMapper.selectAllResearchGroup();
        } else {
            groups = researchGroupMapper.selectResearchGroup(groupName);
        }
        List<String> fundingNames = fundingMapper.getAllFundingName();
        ArrayList<HashMap<String, Object>> whole_res = new ArrayList<>();


        for (ResearchGroup group : groups) {
            HashMap<String, Object> res = new HashMap<>();
            String group_name = group.getName();
            ArrayList<HashMap<String, Object>> arrayList = new ArrayList<>();

            for (String fund_name : fundingNames) {
                GroupFund groupFund = fundingMapper.selectFunding(group_name, fund_name);
                HashMap<String, Object> ress = new HashMap<>();
                ress.put("value", groupFund.getTotal());
                ress.put("used", groupFund.getUsed());
                ress.put("rest", groupFund.getTotal() - groupFund.getUsed());
                ress.put("execute_rate", groupFund.getUsed()/groupFund.getTotal());
                //Todo:达标率未处理
                ress.put("qualify", 1.0);
                ress.put("fund_name", fund_name);
                arrayList.add(ress);
            }

            res.put("group_name", group_name);
            res.put("fundings", arrayList);
            whole_res.add(res);
        }
        return Result.ok().code(200).message("Success").addData("funding_info", whole_res);
    }
    
    public Result getFundingBySum(){
        List<_MultiUsedTable> multiusedtable = fundingMapper.calculateFundingSum();
        return  Result.ok().code(200).message("Success").addData("funding_info", multiusedtable);
    }
    public Result getAuthorizedFundingDetail(){
        List<_AuthorizedFundingDetail> authorizedFundingDetails = fundingMapper.calculateAuthorizedFundingDetail();
        return  Result.ok().code(200).message("Success").addData("funding_info", authorizedFundingDetails);
    }

    public Result getAuthorizedFundingDetailByGroup(String group_name){
        List<_AuthorizedFundingDetail> authorizedFundingDetails = fundingMapper.calculateAuthorizedFundingDetailBtGroup(group_name);
        return  Result.ok().code(200).message("Success").addData("funding_info", authorizedFundingDetails);
    }

    public Result getExpenditureSummary(){
        List<_ExpenditureSummary> expenditureSumMap = fundingMapper.calculateExpenditureSummary();
        return  Result.ok().code(200).message("Success").addData("funding_info", expenditureSumMap);
    }
    
    public Result getExpenditureSummaryUser(String group){
        List<_ExpenditureSummaryUser> expenditureSumMapUser = fundingMapper.calculateExpenditureSummaryUser(group);
        return Result.ok().code(200).message("Success").addData("funding_info", expenditureSumMapUser);
    }
    
    public Result allocateExerate(String code, String rate){
        fundingMapper.allocateExecuterate(code, rate);
        return Result.ok().code(200).message("Success");
    }

    public Result updateTotalMoneyByExecutionRate(){
        fundingMapper.updateTotalFunding();
//        fundingMapper.deleteZeroTotalFunding();
        return Result.ok().code(200).message("Success");
    }
}
