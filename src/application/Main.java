package application;
	
import javafx.application.Application;
import java.awt.event.ActionEvent;
import java.beans.EventHandler;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;


public class Main extends Application {
			public static int i = 0;
			public static int click = 0;
			@Override
			public void start(Stage stage) throws IOException {
				Employee employee[] = new Employee[100];
				String filePath = "src\\application\\Employee.txt";
				 //Instantiating the File class
			      File file = new File(filePath);
			      //Instantiating the StringBuffer
			      StringBuffer buffer = new StringBuffer();
			      //instantiating the RandomAccessFile
			      RandomAccessFile raFile = new RandomAccessFile(file, "rw");
			      //Reading each line using the readLine() method
			      while(raFile.getFilePointer() < raFile.length()) {
			    	  String[] arrOfStr = raFile.readLine().split(",");
			    	  if (Integer.parseInt(arrOfStr[0]) == 0) {
							employee[i] = new SalariedEmployee(arrOfStr[1], arrOfStr[2], arrOfStr[3],Double.parseDouble(arrOfStr[4]));
							i++;
			    	  }
						else if (Integer.parseInt(arrOfStr[0]) == 1) {
							employee[i] = new HourlyEmployee(arrOfStr[1], arrOfStr[2], arrOfStr[3],Double.parseDouble(arrOfStr[4]), Integer.parseInt(arrOfStr[5]));
							i++;
						} else if (Integer.parseInt(arrOfStr[0]) == 2) {
							employee[i] = new CommissionEmployee(arrOfStr[1], arrOfStr[2], arrOfStr[3],Double.parseDouble(arrOfStr[4]), Double.parseDouble(arrOfStr[5]));
							i++;
						}
						else if (Integer.parseInt(arrOfStr[0]) == 3) {
							employee[i] = new BasePlusCommissionEmployee(arrOfStr[1], arrOfStr[2], arrOfStr[3],Double.parseDouble(arrOfStr[4]), Double.parseDouble(arrOfStr[5]), Double.parseDouble(arrOfStr[6]));
							i++;
						}
			         //buffer.append(raFile.readLine()+System.lineSeparator());
			      }
			      for(int x = 0; x < i; x++) {
			    	  System.out.println(employee[x].toString());
			      }

				//creating label email
				Text firstNameText = new Text("First Name");
			    Text lastNameText = new Text("Last Name"); 
				Text ssnText = new Text("SSN");
				Text searchUpdateSSNText = new Text("Search / Update SSN");
				Text salaryText = new Text("Salary");
				Text grossSalesText = new Text("Gross Sales");
				Text commisionRateText = new Text("Commission Rate");
				Text baseSalaryText = new Text("Base Salary");
				Text weeklySalaryText = new Text("Weekly Salary");
				Text wageText = new Text("Wage");
				Text hoursText = new Text("Hours");
				Text chooseEmployeeTypeText = new Text("Choose Employee Type");				
			    
			    //Creating Text Filed for email        
			     TextField firstNameTextField = new TextField();
			     TextField lastNameTextField = new TextField();       
			     TextField ssnTextField = new TextField(); 
			     ssnTextField.setDisable(true);
			     TextField searchUpdateSSNTextField = new TextField();       
			     TextField salaryTextField = new TextField();       
			     salaryTextField.setDisable(true);
			     TextField grossSalesTextField = new TextField();       
			     TextField commisionRateTextField = new TextField();       
			     TextField baseSalaryTextField = new TextField();       
			     TextField weeklySalaryTextField = new TextField();       
			     TextField wageTextField = new TextField(); 
			     TextField hoursTextField = new TextField();       


			     // TextField etkisiz hale getirmek
			     // firstNameTextField.setDisable(true); 
			     //TextField temizlemek
			     //TextField notification = new TextField ();
			     //notification.setText("Label");   
			     //notification.clear();//

			     
			     //Creating Buttons
			     Button buttonadd = new Button("Add"); 
			     Button buttonsearcbyssn = new Button("Search by SSN"); 
			     Button buttonupdatebyssn = new Button("Update by SSN"); 
			     Button buttoncleanAll = new Button("Clean textFields"); 


			     
			     //Creating a Grid Pane 
			     GridPane gridPane = new GridPane();    
			      
			     //Setting size for the pane 
			     gridPane.setMinSize(500, 300);
			     
			      //Setting the padding  
			      gridPane.setPadding(new Insets(10, 10, 10, 10)); 
			      
			      //Setting the vertical and horizontal gaps between the columns 
			      gridPane.setVgap(5); 
			      gridPane.setHgap(5);      
			      
			      //Setting the Grid alignment 
			      gridPane.setAlignment(Pos.CENTER); 
			      
			      //Add Menu Button
			      MenuItem salariedEmployeeMenuItem = new MenuItem("Salaried Employee");
			      MenuItem hourlyEmployeeMenuItem = new MenuItem("Hourly Employee");
			      MenuItem commisionEmployeeMenuItem = new MenuItem("Commission Employee");
			      MenuItem basePlusCommisionEmployeeMenuItem = new MenuItem("Base Plus Commission Employee");
			      MenuItem noneMenuItem = new MenuItem("None");
			      MenuButton menuButton = new MenuButton("                                                ", null, salariedEmployeeMenuItem, hourlyEmployeeMenuItem, commisionEmployeeMenuItem,basePlusCommisionEmployeeMenuItem,noneMenuItem);
			      HBox hbox = new HBox(menuButton);
			      hbox.setAlignment(Pos.CENTER);
			      //Arranging all the nodes in the grid 
			      gridPane.add(chooseEmployeeTypeText, 1, 0);       
			      gridPane.add(hbox, 2,0); 

			      gridPane.add(firstNameText, 0, 2);       
			      gridPane.add(firstNameTextField, 1, 2); 
			      gridPane.add(lastNameText, 0, 3);       
			      gridPane.add(lastNameTextField, 1, 3);
			      gridPane.add(ssnText, 0, 4);       
			      gridPane.add(ssnTextField, 1, 4);
			      gridPane.add(searchUpdateSSNText, 0, 5);       
			      gridPane.add(searchUpdateSSNTextField, 1, 5);
			      gridPane.add(salaryText, 0, 6);       
			      gridPane.add(salaryTextField, 1, 6);
			      gridPane.add(grossSalesText, 3, 2);       
			      gridPane.add(grossSalesTextField, 4, 2);
			      gridPane.add(commisionRateText, 3, 3);       
			      gridPane.add(commisionRateTextField, 4, 3);
			      gridPane.add(baseSalaryText, 3, 4);       
			      gridPane.add(baseSalaryTextField, 4, 4);
			      gridPane.add(weeklySalaryText, 3, 5);       
			      gridPane.add(weeklySalaryTextField, 4, 5);
			      gridPane.add(wageText, 3, 6);       
			      gridPane.add(wageTextField, 4, 6);
			      gridPane.add(hoursText, 3, 7);       
			      gridPane.add(hoursTextField, 4, 7);
			      
			      gridPane.add(buttonadd, 0, 8); 
			      gridPane.add(buttonsearcbyssn, 1, 8); 
			      gridPane.add(buttonupdatebyssn, 2, 8); 
			      gridPane.add(buttoncleanAll, 3, 8); 
			      
			      
			      
			      //Menu Actions
			      salariedEmployeeMenuItem.setOnAction(event -> {
			    	  menuButton.setText("Salaried Employee");
				      firstNameTextField.setDisable(false);
				      lastNameTextField.setDisable(false); 
				      ssnTextField.setDisable(true);
				      searchUpdateSSNTextField.setDisable(false);
				      salaryTextField.setDisable(true);
				      grossSalesTextField.setDisable(true);
				      commisionRateTextField.setDisable(true);
				      baseSalaryTextField.setDisable(true);
				      weeklySalaryTextField.setDisable(false);
				      wageTextField.setDisable(true); 
				      hoursTextField.setDisable(true); 
				      buttonadd.setDisable(false);
				      buttoncleanAll.setDisable(false);
				      buttonupdatebyssn.setDisable(false);
				      buttonsearcbyssn.setDisable(false);

			    	});
			      hourlyEmployeeMenuItem.setOnAction(event -> {
			    	  menuButton.setText("Hourly Employee");
				      firstNameTextField.setDisable(false);
				      lastNameTextField.setDisable(false); 
				      ssnTextField.setDisable(true);
				      salaryTextField.setDisable(true);
				      grossSalesTextField.setDisable(true); 
				      commisionRateTextField.setDisable(true);
				      baseSalaryTextField.setDisable(true); 
				      weeklySalaryTextField.setDisable(true); 
				      wageTextField.setDisable(false); 
				      hoursTextField.setDisable(false); 
				      buttonadd.setDisable(false);
				      buttoncleanAll.setDisable(false);
				      buttonupdatebyssn.setDisable(false);
				      buttonsearcbyssn.setDisable(false);

			    	});
			      commisionEmployeeMenuItem.setOnAction(event -> {
			    	  menuButton.setText("Commission Employee");
				      firstNameTextField.setDisable(false);
				      lastNameTextField.setDisable(false); 
				      ssnTextField.setDisable(true);
				      salaryTextField.setDisable(true);
				      baseSalaryTextField.setDisable(true);
				      weeklySalaryTextField.setDisable(true); 
				      wageTextField.setDisable(true); 
				      hoursTextField.setDisable(true); 
				      grossSalesTextField.setDisable(false); 
				      commisionRateTextField.setDisable(false);
				      baseSalaryTextField.setDisable(true);	
				      buttonadd.setDisable(false);
				      buttoncleanAll.setDisable(false);
				      buttonupdatebyssn.setDisable(false);
				      buttonsearcbyssn.setDisable(false);

			    	});
			      basePlusCommisionEmployeeMenuItem.setOnAction(event -> {
			    	  menuButton.setText("Base Plus Commission Employee");
				      firstNameTextField.setDisable(false);
				      lastNameTextField.setDisable(false); 
				      ssnTextField.setDisable(true);
				      salaryTextField.setDisable(true);
				      weeklySalaryTextField.setDisable(true);
				      wageTextField.setDisable(true); 
				      hoursTextField.setDisable(true); 
				      grossSalesTextField.setDisable(false);				      
				      commisionRateTextField.setDisable(false); 
				      baseSalaryTextField.setDisable(false);	
				      buttonadd.setDisable(false);
				      buttoncleanAll.setDisable(false);
				      buttonupdatebyssn.setDisable(false);
				      buttonsearcbyssn.setDisable(false);

			    	});
			      noneMenuItem.setOnAction(event -> {
			    	  menuButton.setText("None");
				      firstNameTextField.setDisable(true);
				      lastNameTextField.setDisable(true); 
				      ssnTextField.setDisable(true);
				      searchUpdateSSNTextField.setDisable(true);
				      salaryTextField.setDisable(true); 
				      grossSalesTextField.setDisable(true);				      
				      commisionRateTextField.setDisable(true); 
				      baseSalaryTextField.setDisable(true);				     
				      weeklySalaryTextField.setDisable(true);				     
				      wageTextField.setDisable(true);
				      hoursTextField.setDisable(true);
				      buttonadd.setDisable(true);
				      buttoncleanAll.setDisable(true);
				      buttonupdatebyssn.setDisable(true);
				      buttonsearcbyssn.setDisable(true);


			    	});
			      
			      
			      //Button Actions
			      buttoncleanAll.setOnAction(event -> { ///For kullanma yolunu bul
			    	  firstNameTextField.clear();
			    	  lastNameTextField.clear();
			    	  ssnTextField.clear();
			    	  searchUpdateSSNTextField.clear();
			    	  salaryTextField.clear();
			    	  grossSalesTextField.clear();
			    	  commisionRateTextField.clear();
			    	  baseSalaryTextField.clear();
			    	  weeklySalaryTextField.clear();
			    	  wageTextField.clear();
			    	  hoursTextField.clear(); 	  
			    	});
			      buttonadd.setOnAction(event -> { ///For kullanma yolunu bul
			    	  if( menuButton.getText() == "Salaried Employee") {
			    		  if (Double.parseDouble(weeklySalaryTextField.getText()) < 0) {
			    			  Alert alert = new Alert(AlertType.INFORMATION);
			    			  alert.setTitle("Information Dialog");
			    			  alert.setHeaderText(null);
			    			  alert.setContentText("Weekly Salary must be higher than or equal to 0!");
			    			  alert.showAndWait();
			    		  } else {
			    			  employee[i] = new SalariedEmployee(firstNameTextField.getText(), lastNameTextField.getText(), String.valueOf(i),Double.parseDouble(weeklySalaryTextField.getText()));
			    			  ssnTextField.setText(String.valueOf(i));
			    			  i++;
			    			  click = 1;
			    		  }

			    	  }
			    	  else if( menuButton.getText() == "Hourly Employee") {
			    		  if (Double.parseDouble(wageTextField.getText()) < 0) {
			    			  Alert alert = new Alert(AlertType.INFORMATION);
			    			  alert.setTitle("Information Dialog");
			    			  alert.setHeaderText(null);
			    			  alert.setContentText("Wage must be higher than or equal to 0!");
			    			  alert.showAndWait();
			    		  } 
			    		  else if (Double.parseDouble(hoursTextField.getText()) < 0 || Double.parseDouble(hoursTextField.getText()) >= 168) {
			    			  Alert alert = new Alert(AlertType.INFORMATION);
			    			  alert.setTitle("Information Dialog");
			    			  alert.setHeaderText(null);
			    			  alert.setContentText("Hours must be higher than or equal to 0 and lower than 168!");
			    			  alert.showAndWait();
			    		  } else {
			    			  employee[i] = new HourlyEmployee(firstNameTextField.getText(), lastNameTextField.getText(), String.valueOf(i),Double.parseDouble(wageTextField.getText()),Integer.parseInt(hoursTextField.getText()));
			    			  ssnTextField.setText(String.valueOf(i));
			    			  i++;
			    			  click = 1;
			    			  
			    		  }
			    	  }
			    	  else if( menuButton.getText() == "Commission Employee") {
			    		  if (Double.parseDouble(grossSalesTextField.getText()) < 0) {
			    			  Alert alert = new Alert(AlertType.INFORMATION);
			    			  alert.setTitle("Information Dialog");
			    			  alert.setHeaderText(null);
			    			  alert.setContentText("Gross Sales must be higher than or equal to 0!");
			    			  alert.showAndWait();
			    		  } 
			    		  else if (Double.parseDouble(commisionRateTextField.getText()) <= 0 || Double.parseDouble(commisionRateTextField.getText()) >= 1) {
			    			  Alert alert = new Alert(AlertType.INFORMATION);
			    			  alert.setTitle("Information Dialog");
			    			  alert.setHeaderText(null);
			    			  alert.setContentText("Commission Rate must be between 0 and 1!");
			    			  alert.showAndWait();
			    		  }
			    		  else {
			    			  employee[i] = new CommissionEmployee(firstNameTextField.getText(), lastNameTextField.getText(), String.valueOf(i),Double.parseDouble(grossSalesTextField.getText()),Double.parseDouble(commisionRateTextField.getText()));
			    			  ssnTextField.setText(String.valueOf(i));
			    			  i++;
			    			  click = 1;
			    			  
			    		  }
			    	  }
			    	  else if( menuButton.getText() == "Base Plus Commission Employee") {
			    		  if (Double.parseDouble(grossSalesTextField.getText()) < 0) {
			    			  Alert alert = new Alert(AlertType.INFORMATION);
			    			  alert.setTitle("Information Dialog");
			    			  alert.setHeaderText(null);
			    			  alert.setContentText("Gross Sales must be higher than or equal to 0!");
			    			  alert.showAndWait();
			    		  } 
			    		  else if (Double.parseDouble(commisionRateTextField.getText()) <= 0 || Double.parseDouble(commisionRateTextField.getText()) >= 1) {
			    			  Alert alert = new Alert(AlertType.INFORMATION);
			    			  alert.setTitle("Information Dialog");
			    			  alert.setHeaderText(null);
			    			  alert.setContentText("Commission Rate must be between 0 and 1!");
			    			  alert.showAndWait();
			    		  }
			    		  else if (Double.parseDouble(baseSalaryTextField.getText()) < 0) {
			    			  Alert alert = new Alert(AlertType.INFORMATION);
			    			  alert.setTitle("Information Dialog");
			    			  alert.setHeaderText(null);
			    			  alert.setContentText("Base Salary must be higher than or equal to 0!");
			    			  alert.showAndWait();
			    		  }else {
			    			  employee[i] = new BasePlusCommissionEmployee(firstNameTextField.getText(), lastNameTextField.getText(), String.valueOf(i),Double.parseDouble(grossSalesTextField.getText()),Double.parseDouble(commisionRateTextField.getText()),Integer.parseInt(baseSalaryTextField.getText()));
			    			  ssnTextField.setText(String.valueOf(i));
			    			  i++;		
			    			  click = 1;
			    		  }
			    	  }
			    	  if (click == 1) {
			    		  click = 0;
			    		  try{
			    			  FileWriter fwrite = new FileWriter(file);
			    			  String text;
			    			  for(int x = 0; x < i; x++) {
			    				  System.out.println(employee[x].getClass().getSimpleName());
			    				  if (employee[x].getClass().getSimpleName().equals("SalariedEmployee")) {
			    					  text = "0," + employee[x].getFirstName() + "," + employee[x].getLastName() + "," + employee[x].getSSN() + "," + ((SalariedEmployee) employee[x]).getWeeklySalary() + "\n";
			    					  fwrite.write(text);
			    				  }
			    				  else if (employee[x].getClass().getSimpleName().equals("HourlyEmployee")) {
			    					  text = "1," + employee[x].getFirstName() + "," + employee[x].getLastName() + "," + employee[x].getSSN() + "," + ((HourlyEmployee) employee[x]).getWage() + "," + ((HourlyEmployee) employee[x]).getHours() + "\n";
			    					  fwrite.write(text);
			    				  }
			    				  else if (employee[x].getClass().getSimpleName().equals("CommissionEmployee")) {
			    					  text = "2," + employee[x].getFirstName() + "," + employee[x].getLastName() + "," + employee[x].getSSN() + "," + ((CommissionEmployee) employee[x]).getGrossSales() + "," + ((CommissionEmployee) employee[x]).getCommissionRate() + "\n";
			    					  fwrite.write(text);
			    				  }
			    				  else if (employee[x].getClass().getSimpleName().equals("BasePlusCommissionEmployee")) {
			    					  text = "3," + employee[x].getFirstName() + "," + employee[x].getLastName() + "," + employee[x].getSSN() + "," + ((BasePlusCommissionEmployee) employee[x]).getGrossSales() + "," + ((BasePlusCommissionEmployee) employee[x]).getCommissionRate() + "," + ((BasePlusCommissionEmployee) employee[x]).getBaseSalary() + "\n";
			    					  
			    					  fwrite.write(text);
			    				  }
			    			  }
			    			  fwrite.close();
			    			  }catch (Exception e){
			    			  e.printStackTrace();
			    			  System.out.println("Exception occured..");
			    			  }
			    	  }
			    	});
			      buttonsearcbyssn.setOnAction(event -> {
			    	  String var = searchUpdateSSNTextField.getText();
			    	  firstNameTextField.clear();
			    	  lastNameTextField.clear();
			    	  ssnTextField.clear();
			    	  salaryTextField.clear();
			    	  grossSalesTextField.clear();
			    	  commisionRateTextField.clear();
			    	  baseSalaryTextField.clear();
			    	  weeklySalaryTextField.clear();
			    	  wageTextField.clear();
			    	  hoursTextField.clear();
			    	  for(int x = 0; x < i; x++) {
			    		 if (employee[x].getSSN().equals(var)) {
			    			 firstNameTextField.setText(employee[x].getFirstName());
			    			 lastNameTextField.setText(employee[x].getLastName());
			    			 ssnTextField.setText(employee[x].getSSN());
			    			 salaryTextField.setText(String.valueOf(employee[x].getPaymentAmount()));
			    			 System.out.println(employee[x].getClass().getSimpleName());
			    			 if(employee[x].getClass().getSimpleName().equals("SalariedEmployee")) {
				    			 weeklySalaryTextField.setText(String.valueOf(((SalariedEmployee) employee[x]).getWeeklySalary()));

			    			 }
			    			 else if(employee[x].getClass().getSimpleName().equals("HourlyEmployee")) {
				    			 wageTextField.setText(String.valueOf(((HourlyEmployee) employee[x]).getWage()));
				    			 hoursTextField.setText(String.valueOf(((HourlyEmployee) employee[x]).getHours()));

			    			 }
			    			 else if(employee[x].getClass().getSimpleName().equals("CommissionEmployee")) {
				    			 grossSalesTextField.setText(String.valueOf(((CommissionEmployee) employee[x]).getGrossSales()));
				    			 commisionRateTextField.setText(String.valueOf(((CommissionEmployee) employee[x]).getCommissionRate()));

			    			 }
			    			 else if(employee[x].getClass().getSimpleName().equals("BasePlusCommissionEmployee")) {
			    				 grossSalesTextField.setText(String.valueOf(((CommissionEmployee) employee[x]).getGrossSales()));
			    				 commisionRateTextField.setText(String.valueOf(((CommissionEmployee) employee[x]).getCommissionRate()));
				    			 baseSalaryTextField.setText(String.valueOf(((BasePlusCommissionEmployee) employee[x]).getBaseSalary()));

			    			 }
			    			 break;
			    		 }
			    	  }
			    	});
			      buttonupdatebyssn.setOnAction(event -> { ///For kullanma yolunu bul
			    	  String var = searchUpdateSSNTextField.getText();
			    	  for(int x = 0; x < i; x++) {
			    		 if (employee[x].getSSN().equals(var)) {
			    			 if ( firstNameTextField.getText() != "" && firstNameTextField.getText() != employee[x].getFirstName()) {
			    				 employee[x].setFirstName(firstNameTextField.getText());
			    			 }
			    			 firstNameTextField.setText(employee[x].getFirstName());
			    			 if ( lastNameTextField.getText() != "" && lastNameTextField.getText() != employee[x].getLastName()) {
			    				 employee[x].setLastName(lastNameTextField.getText());
			    			 }
			    			 lastNameTextField.setText(employee[x].getLastName());
			    			 ssnTextField.setText(employee[x].getSSN());
			    			 salaryTextField.setText(String.valueOf(employee[x].getPaymentAmount()));
			    			 if(employee[x].getClass().getSimpleName().equals("SalariedEmployee")) {
			    				 if ( weeklySalaryTextField.getText() != "" ) {
			    					 if (Double.parseDouble(weeklySalaryTextField.getText()) < 0) {
						    			  Alert alert = new Alert(AlertType.INFORMATION);
						    			  alert.setTitle("Information Dialog");
						    			  alert.setHeaderText(null);
						    			  alert.setContentText("Weekly Salary must be higher than or equal to 0!");
						    			  alert.showAndWait();
						    		  } else {
						    			  click = 1;
						    			  ((SalariedEmployee) employee[x]).setWeeklySalary(Double.parseDouble(weeklySalaryTextField.getText()));
						    			  salaryTextField.setText(String.valueOf(((SalariedEmployee) employee[x]).getWeeklySalary()));
						    			  weeklySalaryTextField.setText(String.valueOf(((SalariedEmployee) employee[x]).getWeeklySalary()));
						    			  
									       
						    		  }
			    				 }
			    			 }
			    			 else if(employee[x].getClass().getSimpleName().equals("HourlyEmployee")) {
			    				 if (Double.parseDouble(wageTextField.getText()) < 0) {
					    			  Alert alert = new Alert(AlertType.INFORMATION);
					    			  alert.setTitle("Information Dialog");
					    			  alert.setHeaderText(null);
					    			  alert.setContentText("Wage must be higher than or equal to 0!");
					    			  alert.showAndWait();
					    		  } 
					    		  else if (Double.parseDouble(hoursTextField.getText()) < 0 || Double.parseDouble(hoursTextField.getText()) >= 168) {
					    			  Alert alert = new Alert(AlertType.INFORMATION);
					    			  alert.setTitle("Information Dialog");
					    			  alert.setHeaderText(null);
					    			  alert.setContentText("Hours must be higher than or equal to 0 and lower than 168!");
					    			  alert.showAndWait();
					    		  } else {
					    			  click = 1;
					    			  if ( wageTextField.getText() != "" && wageTextField.getText() != String.valueOf(((HourlyEmployee) employee[x]).getWage())) {
					    				  ((HourlyEmployee) employee[x]).setWage(Double.parseDouble(wageTextField.getText()));
					    				  wageTextField.setText(String.valueOf(((HourlyEmployee) employee[x]).getWage()));
					    			  }
					    			  if ( hoursTextField.getText() != "" && hoursTextField.getText() != String.valueOf(((HourlyEmployee) employee[x]).getHours())) {
					    				  ((HourlyEmployee) employee[x]).setHours(Integer.parseInt(hoursTextField.getText()));
					    				  hoursTextField.setText(String.valueOf(((HourlyEmployee) employee[x]).getHours()));
					    			  }
					    			  
					    		  }
			    			 }
			    			 else if(employee[x].getClass().getSimpleName().equals("CommissionEmployee")) {
			    				 if (Double.parseDouble(grossSalesTextField.getText()) < 0) {
					    			  Alert alert = new Alert(AlertType.INFORMATION);
					    			  alert.setTitle("Information Dialog");
					    			  alert.setHeaderText(null);
					    			  alert.setContentText("Gross Sales must be higher than or equal to 0!");
					    			  alert.showAndWait();
					    		  } 
					    		  else if (Double.parseDouble(commisionRateTextField.getText()) <= 0 || Double.parseDouble(commisionRateTextField.getText()) >= 1) {
					    			  Alert alert = new Alert(AlertType.INFORMATION);
					    			  alert.setTitle("Information Dialog");
					    			  alert.setHeaderText(null);
					    			  alert.setContentText("Commission Rate must be between 0 and 1!");
					    			  alert.showAndWait();
					    		  } else {
					    			  click = 1;
					    			  if ( grossSalesTextField.getText() != "" && grossSalesTextField.getText() != String.valueOf(((CommissionEmployee) employee[x]).getGrossSales())) {
					    				  ((CommissionEmployee) employee[x]).setGrossSales(Double.parseDouble(grossSalesTextField.getText()));
					    				  grossSalesTextField.setText(String.valueOf(((CommissionEmployee) employee[x]).getGrossSales()));
					    			  }
					    			  if ( commisionRateTextField.getText() != "" && commisionRateTextField.getText() != String.valueOf(((CommissionEmployee) employee[x]).getCommissionRate())) {
					    				  ((CommissionEmployee) employee[x]).setCommissionRate(Double.parseDouble(commisionRateTextField.getText()));
					    				  commisionRateTextField.setText(String.valueOf(((CommissionEmployee) employee[x]).getCommissionRate()));
					    			  }
					    			  
					    		  }
			    			 }
			    			 else if(employee[x].getClass().getSimpleName().equals("BasePlusCommissionEmployee")) {
			    				 if (Double.parseDouble(grossSalesTextField.getText()) < 0) {
					    			  Alert alert = new Alert(AlertType.INFORMATION);
					    			  alert.setTitle("Information Dialog");
					    			  alert.setHeaderText(null);
					    			  alert.setContentText("Gross Sales must be higher than or equal to 0!");
					    			  alert.showAndWait();
					    		  } 
					    		  else if (Double.parseDouble(commisionRateTextField.getText()) <= 0 || Double.parseDouble(commisionRateTextField.getText()) >= 1) {
					    			  Alert alert = new Alert(AlertType.INFORMATION);
					    			  alert.setTitle("Information Dialog");
					    			  alert.setHeaderText(null);
					    			  alert.setContentText("Commission Rate must be between 0 and 1!");
					    			  alert.showAndWait();
					    		  }
					    		  else if (Double.parseDouble(baseSalaryTextField.getText()) < 0) {
					    			  Alert alert = new Alert(AlertType.INFORMATION);
					    			  alert.setTitle("Information Dialog");
					    			  alert.setHeaderText(null);
					    			  alert.setContentText("Base Salary must be higher than or equal to 0!");
					    			  alert.showAndWait();
					    		  } else {
					    			  click = 1;
					    			  if ( grossSalesTextField.getText() != "" && grossSalesTextField.getText() != String.valueOf(((CommissionEmployee) employee[x]).getGrossSales())) {
					    				  ((CommissionEmployee) employee[x]).setGrossSales(Double.parseDouble(grossSalesTextField.getText()));
					    				  grossSalesTextField.setText(String.valueOf(((CommissionEmployee) employee[x]).getGrossSales()));
					    			  }
					    			  if ( commisionRateTextField.getText() != "" && commisionRateTextField.getText() != String.valueOf(((CommissionEmployee) employee[x]).getCommissionRate())) {
					    				  ((CommissionEmployee) employee[x]).setCommissionRate(Double.parseDouble(commisionRateTextField.getText()));
					    				  commisionRateTextField.setText(String.valueOf(((CommissionEmployee) employee[x]).getCommissionRate()));
					    			  }
					    			  if ( baseSalaryTextField.getText() != "" && baseSalaryTextField.getText() != String.valueOf(((BasePlusCommissionEmployee) employee[x]).getBaseSalary())) {
					    				  ((BasePlusCommissionEmployee) employee[x]).setBaseSalary(Double.parseDouble(baseSalaryTextField.getText()));
					    				  baseSalaryTextField.setText(String.valueOf(((BasePlusCommissionEmployee) employee[x]).getBaseSalary()));
					    			  }
					    			  
					    		  }

			    			 }
			    			 break;
			    		 }
			    	  }
			    	  if (click == 1) {
			    		  click = 0;
			    		  try{
			    			  FileWriter fwrite = new FileWriter(file);
			    			  String text;
			    			  for(int x = 0; x < i; x++) {
			    				  System.out.println(employee[x].getClass().getSimpleName());
			    				  if (employee[x].getClass().getSimpleName().equals("SalariedEmployee")) {
			    					  text = "0," + employee[x].getFirstName() + "," + employee[x].getLastName() + "," + employee[x].getSSN() + "," + ((SalariedEmployee) employee[x]).getWeeklySalary() + "\n";
			    					  fwrite.write(text);
			    				  }
			    				  else if (employee[x].getClass().getSimpleName().equals("HourlyEmployee")) {
			    					  text = "1," + employee[x].getFirstName() + "," + employee[x].getLastName() + "," + employee[x].getSSN() + "," + ((HourlyEmployee) employee[x]).getWage() + "," + ((HourlyEmployee) employee[x]).getHours() + "\n";
			    					  fwrite.write(text);
			    				  }
			    				  else if (employee[x].getClass().getSimpleName().equals("CommissionEmployee")) {
			    					  text = "2," + employee[x].getFirstName() + "," + employee[x].getLastName() + "," + employee[x].getSSN() + "," + ((CommissionEmployee) employee[x]).getGrossSales() + "," + ((CommissionEmployee) employee[x]).getCommissionRate() + "\n";
			    					  fwrite.write(text);
			    				  }
			    				  else if (employee[x].getClass().getSimpleName().equals("BasePlusCommissionEmployee")) {
			    					  text = "3," + employee[x].getFirstName() + "," + employee[x].getLastName() + "," + employee[x].getSSN() + "," + ((BasePlusCommissionEmployee) employee[x]).getGrossSales() + "," + ((BasePlusCommissionEmployee) employee[x]).getCommissionRate() + "," + ((BasePlusCommissionEmployee) employee[x]).getBaseSalary() + "\n";
			    					  
			    					  fwrite.write(text);
			    				  }
			    			  }
			    			  fwrite.close();
			    			  }catch (Exception e){
			    			  e.printStackTrace();
			    			  System.out.println("Exception occured..");
			    			  }
			    	  }
			    	});
			      
			         

			      
			      
			      //Creating a scene object 
			      Scene scene = new Scene(gridPane); 
			       
			      //Setting title to the Stage 
			      stage.setTitle("Employee Salary Calculator"); 
			         
			      //Adding scene to the stage 
			      stage.setScene(scene);
			      
			      //Displaying the contents of the stage 
			      stage.show(); 
			}
			

	

	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		launch(args);
	}	
}
