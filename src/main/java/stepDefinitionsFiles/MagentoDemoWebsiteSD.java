package stepDefinitionsFiles;

import java.io.IOException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import javaFiles.Magento;
import javaFiles.Paths;


public class MagentoDemoWebsiteSD {

	
	Magento magento = new Magento();	
	Paths paths = new Paths();	

	String Locator ;
	
	@Given("I successfully connected to the Landing page using label {string}")
	public void i_successfully_connected_to_the_landing_page_using_label(String Landing_page_label) throws IOException {

		// Maximize Window
		magento.startDriver ();
		// Open Home Page
		magento.OpenURL (paths.Landing_URL);
		// Set locator of label to be used in assertion
				Locator = "Actual_Landing_page_label";
		// Check the founded label match the expected text
				magento.assert_label (Locator,Landing_page_label);
		
	}


	
	@When("I click on register button")
	public void i_click_on_register_button() throws IOException, InterruptedException {
		// Set locator of label to be used in assertion
		Locator = "Register_button";
		magento.Button(Locator);

	}

	
	@Then("I get the registeration page using label {string}")
	public void i_get_the_registeration_page_using_label(String Register_page_label) throws IOException {
	
		// Set locator of label to be used in assertion
		Locator = "Register_label";
		// Check the founded label match the expected text
		magento.assert_label (Locator,Register_page_label);
		
	}

	
	

@When("I fill all registration data from the excel file located in {string}")
public void i_fill_all_registration_data_from_the_excel_file_located_in(String FilePath) throws IOException {
		
	
	
	// Add First Name
		// Set locator
				Locator = "First_Name" ;				
		// Get data from excel file
				String First_Name = magento.GetFromExcel(FilePath,12, Locator);
				magento.AddText(Locator,First_Name);
				
							
		// Add Last Name
			// Set locator
				Locator = "Last_Name" ;
			// Get data from excel file
				String Last_Name = magento.GetFromExcel(FilePath,12, Locator) ;
				magento.AddText(Locator,Last_Name);
		
		// Add Email Address
			// Set locator
				Locator = "Email_Address" ;
			// Get data from excel file
				String Email_Address = magento.GetFromExcel(FilePath,12, Locator);
				magento.AddText(Locator,Email_Address);

		// Add Password
			// Set locator
				Locator = "Password" ;
			// Get data from excel file
				String Password = magento.GetFromExcel(FilePath,12, Locator);
				magento.AddText(Locator,Password);

		// Add Confirm Password
			// Set locator
				Locator = "Confirm_Password" ;
			// Get data from excel file
				String Confirm_Password = magento.GetFromExcel(FilePath,12, Locator);
				magento.AddText(Locator,Confirm_Password);
				
	}

	@When("I click register")
	public void i_click_register() throws IOException, InterruptedException {

		Locator = "Register_button_2";
		magento.Button(Locator);

	}

	@Then("I assert that I registered successfully using {string}")
	public void i_assert_that_i_registered_successfully_using(String Message) throws IOException {

		// Set locator of label to be used in assertion
		Locator = "Success_Message";
		// Check the founded label match the expected text
		magento.assert_label (Locator,Message);
		magento.Close();
	
	}



	@Then("I assert that I found an error message as {string}")
	public void i_assert_that_i_found_an_error_message_as(String Message) throws IOException {
		// Set locator of label to be used in assertion
		Locator = "Error_Message";
		// Check the founded label match the expected text
		magento.assert_label (Locator,Message);
		magento.Close();
	}



@When("I click on Login button")
public void i_click_on_login_button() throws IOException, InterruptedException {

	Locator = "Login_button";
	magento.Button(Locator);

}

@Then("I get the Login page using label {string}")
public void i_get_the_login_page_using_label(String Login_page_label) throws IOException {
	// Set locator of label to be used in assertion
	Locator = "Login_Label";
	// Check the founded label match the expected text
	magento.assert_label (Locator,Login_page_label);

}

@When("I fill all login data from the excel file located in {string}")
public void i_fill_all_login_data_from_the_excel_file_located_in(String FilePath) throws IOException {

	// Add Email Address
	// Set locator
		Locator = "Login_Email_Address" ;
	// Get data from excel file
		String Email_Address = magento.GetFromExcel(FilePath,12, Locator);
		magento.AddText(Locator,Email_Address);

// Add Password
	// Set locator
		Locator = "Login_Password" ;
	// Get data from excel file
		String Password = magento.GetFromExcel(FilePath,12, Locator);
		magento.AddText(Locator,Password);

}

@When("I click login")
public void i_click_login() throws IOException, InterruptedException {

	Locator = "Login_button_2";
	magento.Button(Locator);

	
}

@Then("I assert that I login successfully using {string}")
public void i_assert_that_i_login_successfully_using(String Hello_label) throws IOException {
	// Set locator of label to be used in assertion
	Locator = "Hello_label";
	// Check the founded label match the expected text
	magento.assert_label (Locator,Hello_label);

}

@When("I hover on the WOMEN Pants & Denim menu")
public void i_hover_on_the_women_pants_denim_menu() throws IOException {

	Locator = "MouseHover";
	magento.HoverByMouse(Locator);
}

@Then("I assert there is at least one product")
public void i_assert_there_is_at_least_one_product() throws IOException {
	Locator = "AssertProducts" ;
	magento.CheckProductList(Locator);
}

@When("I view details of any of the items")
public void i_view_details_of_any_of_the_items() throws InterruptedException, IOException {
	Locator = "ViewDetails" ;
	magento.Button(Locator);

}

@When("I select the Color & Size")
public void i_select_the_color_size() {

}

@When("I add the item to your cart.")
public void i_add_the_item_to_your_cart() throws IOException, InterruptedException {
	Locator = "AddToCart_Button" ;
	magento.Button(Locator);

}

@Then("I assert on the Grand Total is less than you budget of {int} dollor")
public void i_assert_on_the_grand_total_is_less_than_you_budget_of_dollor(Integer int1) {

	magento.Close();
	
}
 

}
