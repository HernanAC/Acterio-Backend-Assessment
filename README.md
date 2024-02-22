<br/>
<p align="center">
  <a href="https://github.com/HernanAC/Acterio-Backend-Assessment">
    <img src="acterio.jpg" alt="Logo" width="80" height="80">
  </a>

  <h3 align="center">Backend Coding Challenge</h3>

</p>

This coding challenge was done using H2 and Java with dependencies such as Spring Web, Spring Data JPA, Spring Security, among others. The idea of this project is to create a REST Api server that can register users, handle logins and return email ocurrences per domain.

## Testing the project

Since this project was made with H2, you can check the UI to follow the database status and its modifications in the following link: http://localhost:8080/h2-ui/

![h2](https://github.com/HernanAC/Acterio-Backend-Assessment/assets/39239369/d050e9bc-422e-41ac-ad45-decc07f17c12)

If you want to register an user, you can do it from Postman by using the following endpoint:

![register](https://github.com/HernanAC/Acterio-Backend-Assessment/assets/39239369/ca743ec4-2032-41cf-bb0c-e7f96bf63c40)

If it's made correctly it will return the name of the person you've registered. You can register as many people as you want, but if someone has the same email it will tell you that there's already people with that email registered.

Once you've logged a person, you can check if you can log in using the next endpoint:

![login](https://github.com/HernanAC/Acterio-Backend-Assessment/assets/39239369/dcaf270b-d613-4955-9ada-39e505e5920f)

In case credentials are correct, you will get a positive answer, in the last case, the email or password weren't correct so you get a negative answer. 

In case you want to delete someone, you can do it using the following endpoint:

![delete](https://github.com/HernanAC/Acterio-Backend-Assessment/assets/39239369/0926bc31-efc9-41cc-be4c-d9579caa33b5)

If it was done correctly, it will return a 200 OK status, which means the person with ID 2 was deleted. 

And last but not least, if you use the endpoint "count" you will be able to see the count of emails by domain: 

![count](https://github.com/HernanAC/Acterio-Backend-Assessment/assets/39239369/9991023e-9cb5-4135-a42e-36f31ea84163)

And, this is how the database would look since it was saved with Spring Security: 

![h2f](https://github.com/HernanAC/Acterio-Backend-Assessment/assets/39239369/32709e07-70cb-43b0-a0af-dcd4db79f1ed)






