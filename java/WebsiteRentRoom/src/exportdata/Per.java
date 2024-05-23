package exportdata;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class Per {
   
       private String username,username1,username2;
       private String password,password1,password2;
       private String firstname,firstname1,firstname2;
       private String lastname,lastname1,lastname2;
       private String email,email1,email2;
       private String telephone,telephone1,telephone2;
       private String hfilepath, tfilepath, mfilepath;
       private String location_house;
       private String location,address,transport,username_host;
	   Date lastdate,firstdate,lastdate_house,firstdate_house;
	   int max_number_of_persons_house;
	   double min_value_of_tenancy_house;
       private String description,filepath,type_of_rental_space,filepaths,messages;
       private int living_room,smoking,pets;
       private int event,max_number_of_persons,number_of_beds;
       private int number_of_baths,number_of_bedrooms,min_number_of_days;
       private int reviews,reviews_host,stars;
       private double area,additional_cost_per_person,min_value_of_tenancy;
              
	   String getusername(){
		   return username;
	   }
	   @XmlElement
	   void setusername(String username){
		  this.username = username;
	   }
	   String getpassword(){
		   return password;
	   }
	   @XmlElement
	   void setpassword(String password){
		  this.password = password;
	   }
	   @XmlElement
	   String getfirstname(){
		   return firstname;
	   }
	   void setfirstname(String firstname){
		   this.firstname = firstname;
	   }
	   @XmlElement
	   String getlastname(){
		   return lastname;
	   }
	   void setlastname(String lastname){
		   this.lastname = lastname;
	   } 
	   @XmlElement
	   String getemail(){
		   return email;
	   }
	   void setemail(String email){
		   this.email = email;
	   } 
	   @XmlElement
	   String gettelephone(){
		   return telephone;
	   }
	   void settelephone(String telephone){
		   this.telephone = telephone;
	   }
	   @XmlElement
	   String getmfilepath() {
		   return mfilepath;
	   }
	   void setmfilepath(String mfilepath) {
		   this.mfilepath = mfilepath;
	   }
	   String gethusername(){
		   return username1;
	   }
	   @XmlElement
	   void sethusername(String username){
		  this.username1 = username;
	   }
	   String gethpassword(){
		   return password1;
	   }
	   @XmlElement
	   void sethpassword(String password){
		  this.password1 = password;
	   }
	   @XmlElement
	   String gethfirstname(){
		   return firstname1;
	   }
	   void sethfirstname(String firstname){
		   this.firstname1 = firstname;
	   }
	   @XmlElement
	   String gethlastname(){
		   return lastname1;
	   }
	   void sethlastname(String lastname){
		   this.lastname1 = lastname;
	   } 
	   @XmlElement
	   String gethemail(){
		   return email1;
	   }
	   void sethemail(String email){
		   this.email1 = email;
	   } 
	   @XmlElement
	   String gethtelephone(){
		   return telephone1;
	   }
	   void sethtelephone(String telephone){
		   this.telephone1 = telephone;
	   }
	   @XmlElement
	   String gethfilepath() {
		   return hfilepath;
	   }
	   void sethfilepath(String hfilepath) {
		   this.hfilepath = hfilepath;
	   }
	   void setfirstdate(Date date){
		   this.firstdate = date;
	   }
	   @XmlElement
	   Date getfirstdate(){
		   return firstdate;
	   }
	   void setfilepath(String filepath){
		   this.filepath = filepath;
	   }
	   @XmlElement
	   String getfilepath(){
		   return filepath;
	   }
	   void setfilepaths(String filepaths){
		   this.filepaths = filepaths;
	   }
	   @XmlElement
	   String getfilepaths(){
		   return filepaths;
	   }
	   void settfrs(String type_of_rental_space){
		   this.type_of_rental_space = type_of_rental_space;
	   }
	   @XmlElement
	   String gettfrs(){
		   return type_of_rental_space;
	   }
	   void setlocation(String location){
		   this.location = location;
	   }
	   @XmlElement
	   String getlocation(){
		   return location;
	   }
	   void setaddress(String address) {
		   this.address = address;
	   }
	   @XmlElement
	   String getaddress() {
		   return address;
	   }
	   void settransport(String transport) {
		   this.transport = transport;
	   }
	   @XmlElement
	   String gettransport() {
		   return transport;
	   }
	   void setpets(int pets){
		   this.pets = pets;
	   }
	   @XmlElement
	   int getpets(){
		   return pets;
	   }
	   void setlastdate(Date date){
		   this.lastdate = date;
	   }
	   @XmlElement
	   Date getlastdate(){
		   return lastdate;
	   }
	   void setdescription(String description){
		   this.description = description;
	   }
	   @XmlElement
	   String getdescription(){
		   return description;
	   }
	   void setsmoking(int smoking){
		   this.smoking = smoking;
	   }
	   @XmlElement
	   int getsmoking(){
		   return smoking;
	   }
	   void setliving_room(int living_room){
		   this.living_room = living_room;
	   }
	   @XmlElement
	   int getliving_room(){
		   return living_room;
	   }
	   void setevent(int event){
		   this.event = event;
	   }
	   @XmlElement
	   int getevent(){
		   return event;
	   }
	   void setmnop(int max_number_of_persons){
		   this.max_number_of_persons = max_number_of_persons;
	   }
	   @XmlElement
	   int getmnop(){
		   return max_number_of_persons;
	   }
	   void setnob(int number_of_beds){
		   this.number_of_beds = number_of_beds;
	   }
	   @XmlElement
	   int getnob(){
		   return number_of_beds;
	   }
	   void setnobb(int number_of_baths){
		   this.number_of_baths = number_of_baths;
	   }
	   @XmlElement
	   int getnobb(){
		   return number_of_baths;
	   }
	   void setnobbv(int number_of_bedrooms){
		   this.number_of_bedrooms = number_of_bedrooms;
	   }
	   @XmlElement
	   int getnobbv(){
		   return number_of_bedrooms;
	   }
	   void setmnod(int min_number_of_days) {
		   this.min_number_of_days = min_number_of_days;
	   }
	   @XmlElement
	   int getmnod() {
		   return min_number_of_days;
	   }
	   void setarea(double d){
		   this.area = d;
	   }
	   @XmlElement
	   double getarea(){
		   return area;
	   }
	   void setacpp(double d){
		   this.additional_cost_per_person = d;
	   }
	   @XmlElement
	   double getacpp(){
		   return additional_cost_per_person;
	   }
	   void setmvot(double min_value_of_tenancy){
		   this.min_value_of_tenancy = min_value_of_tenancy;
	   }
	   @XmlElement
	   double getmvot(){
		   return min_value_of_tenancy;
	   }
	   
	   void setstars(int stars) {
		   this.stars = stars;
	   }
	   
	   @XmlElement
	   int getstars() {
		   return stars;
	   }
	   
	   void setreviews(int reviews) {
		   this.reviews = reviews;
	   }
	   
	   @XmlElement
	   int getreviews() {
		   return reviews;
	   }
	   
	   void setreviews_host(int reviews_host) {
		   this.reviews_host = reviews_host;
	   }
	   
	   @XmlElement
	   int getreviews_host() {
		   return reviews_host;
	   }
	   
	   void setmessages(String messages){
		   this.messages = messages;
	   }
	   @XmlElement
	   String getmessages(){
		   return messages;
	   }
	   void setusername_host(String username_host) {
		   this.username_host = username_host;
	   }
	   @XmlElement
	   String getusername_host() {
		   return username_host;
	   }
	   String gettusername(){
		   return username2;
	   }
	   @XmlElement
	   void settusername(String username){
		  this.username2 = username;
	   }
	   String gettpassword(){
		   return password2;
	   }
	   @XmlElement
	   void settpassword(String password){
		  this.password2 = password;
	   }
	   @XmlElement
	   String gettfirstname(){
		   return firstname2;
	   }
	   void settfirstname(String firstname){
		   this.firstname2 = firstname;
	   }
	   @XmlElement
	   String gettlastname(){
		   return lastname2;
	   }
	   void settlastname(String lastname){
		   this.lastname2 = lastname;
	   } 
	   @XmlElement
	   String gettemail(){
		   return email2;
	   }
	   void settemail(String email){
		   this.email2 = email;
	   } 
	   @XmlElement
	   String getttelephone(){
		   return telephone2;
	   }
	   void setttelephone(String telephone){
		   this.telephone2 = telephone;
	   }
	   @XmlElement
	   String gettfilepath() {
		   return tfilepath;
	   }
	   void settfilepath(String tfilepath) {
		   this.tfilepath = tfilepath;
	   }
	   @XmlElement
	   String getlocation_house() {
		   return location_house;
	   }
	   void setlocation_house(String location_house) {
		   this.location_house = location_house;
	   }
	   @XmlElement
	   Date getfirstdate_house() {
		   return firstdate_house;
	   }
	   void setfirstdate_house(Date firstdate_house) {
		   this.firstdate_house = firstdate_house;
	   }
	   @XmlElement
	   Date getlastdate_house() {
		   return lastdate_house;
	   }
	   void setlastdate_house(Date lastdate_house) {
		   this.lastdate_house = lastdate_house;
	   }
	   @XmlElement
	   int getmnop_house() {
		   return max_number_of_persons_house;
	   }
	   void setmnop_house(int max_number_of_persons_house) {
		   this.max_number_of_persons_house = max_number_of_persons_house;
	   }
	   @XmlElement
	   double getmvot_house() {
		   return min_value_of_tenancy_house;
	   }
	   void setmvot_house(double min_value_of_tenancy_house) {
		   this.min_value_of_tenancy_house = min_value_of_tenancy_house;
	   }
}
