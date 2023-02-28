package com.business.tonikPages;

import java.util.Set;

import com.android.selectors.Stash_GroupStashSelectors;

public class Stash_GroupStashPage extends BasePage{
	
	public Stash_GroupStashPage() throws InterruptedException {
		super();
	}

	public void groupStashFlow() throws Exception {
		extent.HeaderChildNode("group stash Flow");
		verifyElementPresentAndClick(Stash_GroupStashSelectors.txtManageSavers, "manage savers text");
		verifyElementPresentAndClick(Stash_GroupStashSelectors.txtInviteMoreSavers, "manage text");
		verifyElementPresentAndClick(Stash_GroupStashSelectors.txtItsMe, "manage text");
		verifyElementPresentAndClick(Stash_GroupStashSelectors.txtSendStashInvite, "manage text");
		switchApp();
				
	}
	
	public void switchApp() throws Exception {
		Set<String> view = getDriver().getContextHandles();
		System.out.println(view);
		getDriver().context("NATIVE_APP");
		verifyElementPresentAndClick(Stash_GroupStashSelectors.btnArrowSendMessage, "click on send message");
		waitTime(2000);
		Set<String> view1 = getDriver().getContextHandles();
		System.out.println(view1);
		getDriver().context("NATIVE_APP");
		//String adbRecentApp = "adb shell input keyevent KEYCODE_APP_SWITCH";
	//	Runtime.getRuntime().exec(adbRecentApp);
	}
}
