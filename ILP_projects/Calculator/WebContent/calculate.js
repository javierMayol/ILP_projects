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
    //var val = document.getElementById(id).value;
		document.getElementById("result").value += id;
	};
	
	//function that clear the display
	var clr = function ()
    { 
   		var d = document.getElementById("result");
      d.value = "";
      d.placeholder = "";
    };
	
	//when the equla sign operator is pressed, the solve method is called.
	//This method evalutes the expression enter by the user with the builting
	//eval() function.
	var solve = function () 
  { 
    let x = document.getElementById("result").value;
		if(x != "[0-9 +-*\./]+")
			document.getElementById("result").value = "";

		let y = eval(x);
    console.log(y);
		if(y == "Infinity")
			document.getElementById("result").placeholder = "Cannot divide by zero";
		else
    		document.getElementById("result").value = y;
  };
