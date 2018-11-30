function input() {
  var message_ = document.getElementById("todo");
  var date_ = document.getElementById("date");
  var urgency_ = document.getElementById("urgency");
  var datearray;
  var outputdate="";
  var format1=new RegExp(/^(19|20)[0-9][0-9][-](0[1-9]|1[012])[-](0[1-9]|[12][0-9]|3[01])$/);
  var format2=new RegExp(/^(0[1-9]|1[012])[-](0[1-9]|[12][0-9]|3[01])[-](19|20)[0-9][0-9]$/);
  if(date_.value.match(format1)){
  
	datearray=date_.value.split("-");
  
  
  outputdate+=datearray[1];
  outputdate+="/"
  outputdate+=datearray[2];
  outputdate+="/"
  outputdate+=datearray[0];
  }
  else if(data_.value.match(format2)){
	datearray=date_.value.split("-");
	outputdate+=datearray[0];
	outputdate+="/"
	outputdate+=datearray[1];
	outputdate+="/"
	outputdate+=datearray[2];
  }
  else{
	outputdate=date_.value;
  }
  var data = {
    date: outputdate,
    message: message_.value,
    urgency: urgency_.value
  } 
  // This is the code that pushes data to Firebase
  var currentone=firebase.auth().currentUser;
  var database = firebase.database();
  var ref = database.ref().child(currentone.uid);
  ref.push(data);
 }

//function to delete a certain event from the database
function deletenode(eventsid){
	var root=firebase.database().ref(firebase.auth().currentUser.uid);
	root.child(eventsid).remove();
}

// Getting data from Firebase
 // we use the ref variable created above that takes the argument "todos"
 
 function convertUrgencyToInteger(event){
	if(event.urgency=="notUrgent")
		return 2;
	if(event.urgency=="urgent")
		return 1;
	if(event.urgency=="veryUrgent")
		return 0;
}

function gotData2(data){
	if(data.val()==null){
		var todos=document.getElementById("todolist");
		todos.innerHTML="";
		return;
	}
		
    //console.log(data.val());
    var todos = data.val();
    var keys = Object.keys(todos).sort((a,b)=>{
		return sortKeysByDates(todos[a],todos[b]);
	});
	var ol=document.getElementById("todolist");
	ol.innerHTML="";
    //console.log(keys);
    
    for(var i = 0; i < keys.length; i++) {
      var k = keys[i];
      var date = todos[k].date;
      var message = todos[k].message;
      console.log(date, message);
      console.log("----");
	  
	  var span = document.createElement("SPAN");
	  var closebtn = document.createTextNode("\u00D7");
	  span.appendChild(closebtn);
	  
	  span.addEventListener('click',e=>{
		var eventsid=e.target.parentElement.id;
		deletenode(eventsid);
	  });


      var li = document.createElement("LI");
	  var textnode=document.createTextNode(date+": "+message);
	  li.appendChild(textnode);
	  li.appendChild(span);
	  


      li.setAttribute("id",k);
	  ol.appendChild(li);

   }
}

function sortKeysByDates(o1,o2){
	return sortByDates(o1.date,o2.date);
}

function sortByDates(d1,d2){
	var d1array=d1.split("/");
	var d2array=d2.split("/");
	if(d1array[2]!=d2array[2])
		return d1array[2]-d2array[2];
	else if(d1array[0]!=d2array[1])
		return d1array[0]-d2array[0];
	else if(d1array[1]!=d2array[1])
		return d1array[1]-d2array[1];
	
	
	return 0;
}
 
 function sortByUrgency(o1,o2){
	return convertUrgencyToInteger(o1)-convertUrgencyToInteger(o2);
}

 function gotData(data) {
	if(data.val()==null){
		var todos=document.getElementById("todolist");
		todos.innerHTML="";
		return;
	}
		
    //console.log(data.val());
    var todos = data.val();
    var keys = Object.keys(todos).sort((a,b)=>{
		return sortByUrgency(todos[a],todos[b]);
	});
	var ol=document.getElementById("todolist");
	ol.innerHTML="";
    //console.log(keys);
    
    for(var i = 0; i < keys.length; i++) {
      var k = keys[i];
      var date = todos[k].date;
      var message = todos[k].message;
      console.log(date, message);
      console.log("----");
	  
	  var span = document.createElement("SPAN");
	  var closebtn = document.createTextNode("\u00D7");
	  span.appendChild(closebtn);
	  
	  span.addEventListener('click',e=>{
		var eventsid=e.target.parentElement.id;
		deletenode(eventsid);
	  });


      var li = document.createElement("LI");
	  var textnode=document.createTextNode(date+": "+message);
	  li.appendChild(textnode);
	  li.appendChild(span);
	  


      li.setAttribute("id",k);
	  ol.appendChild(li);

    }
 }

 function errData(err) {
  console.log("error!");
  console.log(err);

 }
