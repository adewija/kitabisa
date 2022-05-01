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
 * desc : register new account template test case
 * */

'go to register page'
WebUI.callTestCase(findTestCase('pages/open browser and go to register page'), [:], FailureHandling.STOP_ON_FAILURE)

'if user email is not empty'
if(email != '') {
	WebUI.callTestCase(findTestCase('Test Cases/pages/input user email'), [('email'):email], FailureHandling.STOP_ON_FAILURE)
	
	if(isEdit) {	
		'click button edit email'
		WebUI.callTestCase(findTestCase('Test Cases/pages/click button edit email'), [('oldEmail'):email], FailureHandling.STOP_ON_FAILURE)
		
		'input new email'
		WebUI.callTestCase(findTestCase('Test Cases/pages/input user email'), [('email'):newEmail], FailureHandling.STOP_ON_FAILURE)
	}
}

'if user name is not empty'
if(name != '') {
	WebUI.callTestCase(findTestCase('Test Cases/pages/input user name'), [('name'):name], FailureHandling.STOP_ON_FAILURE)
}

'if need to click register'
if(isRegister) {
	WebUI.callTestCase(findTestCase('Test Cases/pages/click button register'), [:], FailureHandling.STOP_ON_FAILURE)
}

'if login with certain account'
if(accountType != '') {
	WebUI.callTestCase(findTestCase('pages/click button register with account dynamic'), [('accountType'): accountType], FailureHandling.STOP_ON_FAILURE)
}

'if user already has account'
if(isLogin) {
	WebUI.callTestCase(findTestCase('Test Cases/pages/click login link'), [:], FailureHandling.STOP_ON_FAILURE)
}

'if need to open terms and condition'
if(openTnC) {
	WebUI.callTestCase(findTestCase('Test Cases/pages/open terms and condition'), [:], FailureHandling.STOP_ON_FAILURE)
}