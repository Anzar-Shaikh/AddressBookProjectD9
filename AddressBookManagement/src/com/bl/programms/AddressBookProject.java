package com.bl.programms;
import  org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class AddressBookProject {
    public static void main(String[] args) {
        AddressBookProject utility = new AddressBookProject();
        Scanner sc = new Scanner(System.in);
        System.out.println("*****Welcome to address boob *******");
        System.out.print("Enter what you want to do.\n1-add contact  :: 2-edit contact :: 3-delete contact details : 4-check book : ");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                utility.addContact();
                break;
            case 4:
                utility.showContactDetails();
                break;
            case 2:
                utility.editContactDetails();
                break;
            case 3:
                utility.deleteContactDetails();
                break;
            default:
                System.out.println("Enter correct number : ");
        }

    }

    public void addContact() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter First Name : ");
        String firstName = sc.nextLine();
        System.out.print("Enter Last Name : ");
        String lastName = sc.nextLine();
        System.out.print("Enter address Name : ");
        String address = sc.nextLine();
        System.out.print("Enter city Name : ");
        String city = sc.nextLine();
        System.out.print("Enter stste Name : ");
        String state = sc.nextLine();
        System.out.print("Enter zip code : ");
        String zip = sc.nextLine();
        System.out.print("Enter phone number code  : ");
        String phone = sc.nextLine();
        JSONObject contactDetail = new JSONObject();
        JSONArray contactArray = new JSONArray();

        contactDetail.put("firstName", firstName);
        contactDetail.put("lastName", lastName);
        contactDetail.put("address", address);
        contactDetail.put("city", city);
        contactDetail.put("state", state);
        contactDetail.put("zipCode", zip);
        contactDetail.put("phone", phone);

        JSONObject contactDetails = new JSONObject();
        contactDetails.put("contactDetail", contactDetail);
        contactArray.add(contactDetails);

        try (FileWriter file = new FileWriter("E:\\anzar.json")) {
            file.write(contactArray.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("data added successfully \nThank-you");

    }

    public void editContactDetails() {
        String change, edit;
        JSONParser jasonParser = new JSONParser();
        Scanner sc = new Scanner(System.in);
        System.out.println("What you want to edit : ");
        System.out.print("1-firstName 2-lastName 3-address 4-city 5-state 6-zipCode 7-phone : ");
        int choice = sc.nextInt();
        switch (choice) {

            case 1:
                change = "firstName";
                System.out.print("enter new here : ");
                edit = sc.next();
                editDetails(jasonParser, change, edit);
                break;
            case 2:
                change = "lastName";
                System.out.print("enter new here : ");
                edit = sc.next();
                editDetails(jasonParser, change, edit);
                break;
            case 3:
                change = "address";
                System.out.print("enter new here : ");
                edit = sc.next();
                editDetails(jasonParser, change, edit);
                break;
            case 4 :
                change = "state";
                System.out.print("enter new here : ");
                edit = sc.next();
                editDetails(jasonParser, change, edit);
                break;
            case 5:
                change = "city";
                System.out.print("enter new here : ");
                edit = sc.next();
                editDetails(jasonParser, change, edit);
                break;
            case 6:
                change = "zipCode";
                System.out.print("enter new here : ");
                edit = sc.next();
                editDetails(jasonParser, change, edit);
                break;
            case 7:
                change = "phone";
                System.out.print("enter new here : ");
                edit = sc.next();
                editDetails(jasonParser, change, edit);
                break;
        }
    }

    private void editDetails(JSONParser jasonParser, String change, String edit) {
        try (FileReader reader = new FileReader("E:\\anzar.json")) {
            Object obj = jasonParser.parse(reader);
            JSONArray showContactArray = (JSONArray) obj;
//            System.out.println(showContactArray);
            for (int i = 0; i < showContactArray.size(); i++) {
                JSONObject editContact = (JSONObject) showContactArray.get(i);
//                System.out.println("=========" + editContact.get("contactDetail"));
                JSONObject editDetail = (JSONObject) editContact.get("contactDetail");
                String name = (String) editDetail.get(change);
                System.out.println("old field was : "+name);
                editDetail.put(change, edit);
                System.out.println("New field is : "+editDetail.get(change));
            }
            System.out.println(showContactArray);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private void deleteContactDetails() {
        String change;
        String edit = " " ;
        JSONParser jasonParser = new JSONParser();
        Scanner sc = new Scanner(System.in);
        System.out.println("What you want to edit : ");
        System.out.print("1-firstName 2-lastName 3-address 4-city 5-state 6-zipCode 7-phone : ");
        int choice = sc.nextInt();
        switch (choice) {

            case 1:
                change = "firstName";
                System.out.print("enter new here : ");
//                edit = sc.next();
                editDetails(jasonParser, change,edit);
                break;
            case 2:
                change = "lastName";
                System.out.print("enter new here : ");
//                edit = sc.next();
                editDetails(jasonParser, change, edit);
                break;
            case 3:
                change = "address";
                System.out.print("enter new here : ");
//                edit = sc.next();
                editDetails(jasonParser, change, edit);
                break;
            case 4 :
                change = "state";
                System.out.print("enter new here : ");
//                edit = sc.next();
                editDetails(jasonParser, change, edit);
                break;
            case 5:
                change = "city";
                System.out.print("enter new here : ");
//                edit = sc.next();
                editDetails(jasonParser, change, edit);
                break;
            case 6:
                change = "zipCode";
                System.out.print("enter new here : ");
//                edit = sc.next();
                editDetails(jasonParser, change, edit);
                break;
            case 7:
                change = "phone";
                System.out.print("enter new here : ");
//                edit = sc.next();
                editDetails(jasonParser, change, edit);
                break;
        }
    }

    private void showContactDetails() {
        JSONParser jasonParser = new JSONParser();
        try (FileReader reader = new FileReader("E:\\anzar.json")) {
            Object obj = jasonParser.parse(reader);
            JSONArray showContactArray = (JSONArray) obj;
            System.out.println(showContactArray);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

}
