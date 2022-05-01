import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

/*
 * desc : assertion list in register page
 * */
switch (scenario.toLowerCase()) {
    case 'normal flow':
        'verify counter otp visible'
        WebUI.verifyElementVisible(findTestObject('Object Repository/otp page/div_counter_otp'), FailureHandling.STOP_ON_FAILURE)

        'verify button verifikasi is disabled'
        WebUI.verifyElementHasAttribute(findTestObject('register page/btn_contains_value_dynamic', [('value') : 'Verifikasi']), 
            'disabled', 0, FailureHandling.STOP_ON_FAILURE)

        'verify input 6 digit otp field visible'
        for (def i = 1; i <= 6; i++) {
            WebUI.verifyElementVisible(findTestObject('Object Repository/otp page/ipt_otp_dynamic', [('index') : i]), FailureHandling.STOP_ON_FAILURE)
        }     
    break
		
    case 'empty mandatory fields':
        'verify button register is disabled'
        WebUI.verifyElementHasAttribute(findTestObject('Object Repository/register page/btn_register'), 
            'disabled', 3, FailureHandling.STOP_ON_FAILURE)
    break
		
	case 'verify error message':
		'verify error message visible'
		WebUI.verifyElementVisible(findTestObject('Object Repository/general element/txt_contains_value_dynamic',[('value'): errMessage]), FailureHandling.STOP_ON_FAILURE)
	break
	
	case 'verify header title':
		isLogin? WebUI.verifyElementVisible(findTestObject('Object Repository/register page/header_title_dynamic',[('value'):'Masuk']), FailureHandling.STOP_ON_FAILURE):
		WebUI.verifyElementVisible(findTestObject('Object Repository/register page/header_title_dynamic',[('value'):'Daftar']), FailureHandling.STOP_ON_FAILURE)
	break
	
	case 'verify URL redirection page':
		def actualURL = WebUI.getUrl(FailureHandling.STOP_ON_FAILURE)
		
		assert actualURL.contains(expectedURL)
	break
	case 'verify existing user':
		'verify button continue login as existing user appears'
		WebUI.verifyElementVisible(findTestObject('Object Repository/register page/btn_contains_value_dynamic',[('value'): 'Ya, lanjut']), FailureHandling.STOP_ON_FAILURE)
		
		'verify button cancel login as existing users appears'
		WebUI.verifyElementVisible(findTestObject('Object Repository/register page/btn_contains_value_dynamic',[('value'): 'Tidak, batal']), FailureHandling.STOP_ON_FAILURE)
	break
}