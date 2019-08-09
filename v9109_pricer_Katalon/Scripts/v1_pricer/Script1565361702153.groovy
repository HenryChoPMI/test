import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.RestRequestObjectBuilder
import com.kms.katalon.core.testobject.TestObjectProperty
import com.kms.katalon.core.testobject.impl.HttpTextBodyContent

import java.util.logging.Logger

String endpoint = "https://v9109-pricer.dev.cms.paradymelab.com/v1/pricer/"
String requestMethod = "POST"
String body = '{"requestId":123,"requestIdentifier":"123a","billingRecord":{"npi":"          ","providerNumber":"523027","patientStatus":"02","cmgCode":"C2004","lengthOfStay":5,"coveredDays":5,"lifetimeReserveDays":0,"specialPayIndicator":" ","dischargeDate":"20170415","coveredCharges":10212.75,"patientExpired":false,"patientTransferred":true,"notOutlier":false},"providerRecord":{"npi":"          ","providerNumber":"523027","effectiveDate":"20161001","fiscalYearBeginDate":"20160101","fiscalYearEndDate":"20161231","reportDate":"00000000","terminationDate":"00000000","waiverCode":"N","providerType":"04","intermediaryNumber":0,"currentCensusDivision":4,"msaData":{"wageIndexLocation":"0000","chargeCodeIndex":"0","geolocation":"5080","standardAmountLocation":"5080"},"soleCommunityHospitalYear":"00","lugarReclassCode":"0","temporaryReliefIndicator":" ","federalPpsBlendIndicator":"4","facilitySpecificRate":0,"costOfLivingAdjustment":0,"internToBedRatio":0,"bedSize":0,"costToChargeRatio":0.56100000000000005417888360170763917267322540283203125,"caseMixIndex":0,"ssiRatio":0.0092999999999999992394972281317677698098123073577880859375,"medicaidRatio":0.05909999999999999975575093458246556110680103302001953125,"ppsBlendYearIndicator":0,"specialProviderUpdateFactor":0,"disproportionateShareAdjustmentPercent":0,"cbsaData":{"wageIndex":0,"standardAmountLocation":"00000","specialPaymentIndicator":" ","hospitalQualityIndicator":"1","geolocation":"33340","reclassifiedLocation":"     "},"passthruAmountCapital":0,"passthruAmountDirectMedicalEducation":0,"passthruAmountOrganAcquisition":0,"passthruAmountPlusMisc":0,"capitalPpsPayCode":" ","capitalPpsHospitalSpecificRate":0,"oldCapitalHoldHarmlessRate":0,"newCapitalHoldHarmlessRatio":0,"capitalCostToChargeRatio":0,"newHospitalIndicator":" ","capitalIndirectMedicalEducationRatio":0,"capitalExceptionPaymentRate":0,"valueBasedPurchaseScore":0}}'

TestObjectProperty header = new TestObjectProperty("Content-Type", ConditionType.EQUALS, "application/json")


RequestObject ro = new RestRequestObjectBuilder().withRestUrl(endpoint).withHttpHeaders([header]).withRestRequestMethod(requestMethod).withTextBodyContent(body).build()
ResponseObject respObj = WS.sendRequest(ro)

if(respObj.getStatusCode() != 200) {
	KeywordUtil.markFailed("Status code is not 200 as expected. It is " + respObj.getStatusCode())
}
	 
if(respObj.getWaitingTime() > 5000) {
	KeywordUtil.markFailed("Your request takes more than 5000ms. Actual time is " + respObj.getWaitingTime())
}

Logger logger = Logger.getLogger("")
logger.info(respObj.responseText)
