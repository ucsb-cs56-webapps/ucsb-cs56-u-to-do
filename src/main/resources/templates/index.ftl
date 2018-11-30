<!DOCTYPE html>
<html>
<head>
    <title>Home page</title>
    <script src="fireFunctios.js"></script>
    <#include "head_common.ftl"/>
   
</head>
<body>
<#include "navbar.ftl" />


<p>Username:</p>
  <input type="text" id="username">
  <p>Password:</p>
  <input type="password" id="pass"><br>
  <input type="button" value="Login" id="login">
  <input type="button" value="Sign up" id="signup">
  <input type="hidden" value="Sign out" id="signout">
  <p id="userprompt"></p>
  <p id="testdate"></p>
  <div>
    <label>Date</label>
    <input type="date" name="date" id="date">
  </div>
  <div>
    <label>To-Do</label>
    <input type="text" name="todo" id="todo">
  </div>
  <div>
    <label>Urgency</label>
    <select name="urgency" id="urgency">
      <option value="notUrgent">Not urgent</option>
      <option value="urgent">Urgent</option>
      <option value="veryUrgent">Very Urgent</option>
    </select>
  </div>
  <input type="button" name="Submit" onclick="input()" value="submit"/><br>


<!-- Populate this table from the gotData() function -->
<input type="hidden" id="sUrgency" value="Sort By Urgency">&nbsp;&nbsp;<input type="hidden" id="sDates" value="Sort By Dates">
<p>
  <ol id="todolist">
  </ol>
</p>


  <script>	
  const Username=document.getElementById("username");
  const password=document.getElementById("pass");

  const btnlogin=document.getElementById("login");
  const btnsignup=document.getElementById("signup");
  const btnsignout=document.getElementById("signout");
  const btnsort1=document.getElementById("sUrgency");
  const btnsort2=document.getElementById("sDates");

  btnsignup.addEventListener('click',e=>{
	const email=username.value;
	const passw=password.value;
	const auth=firebase.auth();

	const promise=auth.createUserWithEmailAndPassword(email,passw).catch(e=>{
		var userpro=document.getElementById("userprompt");
		userpro.innerHTML=e;
	});
  });
  
  btnsort1.addEventListener('click',e=>{
	var ref=firebase.database().ref(firebase.auth().currentUser.uid);
	ref.on('value',gotData,errData);
  });
  
  btnsort2.addEventListener('click',e=>{
	var ref=firebase.database().ref(firebase.auth().currentUser.uid);
	ref.on('value',gotData2,errData);
  });


  btnlogin.addEventListener('click',e=>{
    const email=username.value;
    const passw=password.value;
    const auth=firebase.auth();

    const promise=auth.signInWithEmailAndPassword(email,passw);
  promise
  .then(function(){
	var userpro=document.getElementById("userprompt");
	userpro.innerHTML="";
  })
  .catch(e=>{
    firebase.auth().signOut();
	var userpro=document.getElementById("userprompt");
	userpro.innerHTML=e;
  });
  });

  btnsignout.addEventListener('click',e=>{
	var promise=firebase.auth().signOut();
	promise.catch(e=>console.log(e));
  });

  firebase.auth().onAuthStateChanged(firebaseUser=>{
    if(firebaseUser){
	  var ref=firebase.database().ref(firebase.auth().currentUser.uid);
	  var userpro=document.getElementById("userprompt");
	  userpro.innerHTML="";
	  ref.on('value', gotData, errData);
	  btnsignout.type="button";
	  btnsort1.type="button";
	  btnsort2.type="button";
      console.log(firebaseUser);
    }else{
	  btnsignout.type="hidden";
	  btnsort1.type="hidden";
	  btnsort2.type="hidden";
	  var ol=document.getElementById("todolist");
	  ol.innerHTML="";
    }
  });
  </script>

</body>
</html>
