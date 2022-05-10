/**
 * 
	Carlos Mayol
	
	employee id: 1871044
	
	ILP TCS NOAM 2020
 */
	//expression builds the expression entered by user by concatinating the 
	//inputs entered.
	
	var expression = function (id)
	{
		document.getElementById("result").value += document.getElementById(id).value;
		
	};
	
	//function that clear the display
	var clr = function ()
    { 
   		document.getElementById("result").value = ""
    };
	
	//when the equla sign operator is pressed, the solve method is called.
	//This method evalutes the expression enter by the user with the builting
	//eval() function.
	var solve = function () 
    { 
    	let x = document.getElementById("result").value 
	
	
		if(x != "[0-9 +-*\./]+")
			document.getElementById("result").value = ""

		let y = eval(x) 

		if(y == "Infinity")
			document.getElementById("result").value = "Cannot divide by zero"
		else
    		document.getElementById("result").value = y 
   	}
