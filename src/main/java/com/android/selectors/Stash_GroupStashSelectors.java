package com.android.selectors;

import org.openqa.selenium.By;

public class Stash_GroupStashSelectors {

	public static By txtManage=By.xpath("//*[@class='android.widget.TextView' and @text='Manage']");

	public static By txtManageSavers=By.xpath("//*[@class='android.widget.TextView' and @text='Manage Savers']");

	public static By txtInviteMoreSavers=By.xpath("//*[@class='android.widget.TextView' and @text='Invite more savers']");

	public static By txtItsMe=By.xpath("//*[@class='android.widget.TextView' and @text='Its Me']/following-sibling::android.view.ViewGroup");

	public static By txtSendStashInvite=By.xpath("//*[@class='android.widget.TextView' and @text='Send Stash invite via SMS']");

	public static By txtManageBox=By.xpath("(//*[@class='android.widget.ScrollView']/child::android.view.ViewGroup/(child::android.view.ViewGroup)[2]/descendant::android.view.ViewGroup)[9]");

	//Messaging App selectors

	public static By btnArrowSendMessage=By.xpath("//android.widget.Button[@content-desc='Send message']");


}
