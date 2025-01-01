package com.demo.oauthlogin.dto;

public class UserDTO {
  
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String cc;
    private String username;
    private String gender;
    private String phoneNumber;
    
public void setFirstName(String firstName)
{
this.firstName = firstName;
}

public String getFirstName()
{
return firstName;

}                                                

public void setLastName(String lastName)
{
this.lastName = lastName;
}

public String getLastName()
{
return lastName;
}

public void setEmail(String email)
{
this.email = email;
}

public String getEmail()
{
return email;
}

public void setPassword(String password)
{
this.password = password;
}

public String getPassword()
{
return password;
}

public void setCc(String cc)
{
this.cc = cc;
}

public String getCc()
{
return cc;
}

public void setUsername(String username)
{
this.username = username;
}

public String getUsername()
{
return username;
}

public void setGender(String gender)
{
this.gender = gender;
}

public String getGender()
{
return gender;
}

public void setPhoneNumber(String phoneNumber)
{
this.phoneNumber = phoneNumber;
}

public String getPhoneNumber()
{
return phoneNumber;
}
  
}