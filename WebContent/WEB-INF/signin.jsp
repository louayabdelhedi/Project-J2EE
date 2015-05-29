<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head> 
<meta charset="utf-8">
 <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
   <meta name="description" content="Xenon Boostrap Admin Panel" />
    <meta name="author" content="Laborator.co" />
     <title>Sign In</title> 
     <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Arimo:400,700,400italic" id="style-resource-1">
      <link rel="stylesheet" href="assets/css/linecons.css" id="style-resource-2">
       <link rel="stylesheet" href="assets/css/font-awesome.min.css" id="style-resource-3">
        <link rel="stylesheet" href="assets/css/bootstrap.css" id="style-resource-4">
         <link rel="stylesheet" href="assets/css/xenon-core.css" id="style-resource-5"> 
         <link rel="stylesheet" href="assets/css/xenon-forms.css" id="style-resource-6">
          <link rel="stylesheet" href="assets/css/xenon-components.css" id="style-resource-7">
           <link rel="stylesheet" href="assets/css/xenon-skins.css" id="style-resource-8"> 
           <link rel="stylesheet" href="assets/css/custom.css" id="style-resource-9">
            <script src="assets/js/jquery-1.11.1.min.js"></script> 
            <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries --> <!--[if lt IE 9]> <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script> <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script> <![endif]--> <!-- TS1432290114: Xenon - Boostrap Admin Template created by Laborator -->
             </head> 
             <body class="page-body login-page"> 
             <div class="login-container"> 
             <div class="row">
              <div class="col-sm-6"> 
              <script type="text/javascript">
				jQuery(document).ready(function($)
			{
// Reveal Login form
setTimeout(function(){ $(".fade-in-effect").addClass('in'); }, 1);

// Validation and Ajax action
$("form#login").validate({
rules: {
nomEmploye: {
	required: true
},
prenomEmploye: {
	required: true
},
adresseEmploye: {
	required: true
},
cinEmploye: {
	required: true
},
loginEmploye: {
	required: true
},
mpEmploye: {
	required: true
}
},
messages: {
nomEmploye: {
	required: 'Please enter your nomEmploye.'
},
prenomEmploye: {
	required: 'Please enter your prenomEmploye.'
},
adresseEmploye: {
	required: 'Please enter your adresseEmploye.'
},
cinEmploye: {
	required: 'Please enter your cinEmploye.'
},
loginEmploye: {
	required: 'Please enter your loginEmploye.'
},
mpEmploye: {
	required: 'Please enter your mpEmploye.'
}

},

submitHandler: function(form)
{
show_loading_bar(70); // Fill progress bar to 70% (just a given value)
var opts = {
"closeButton": true,
"debug": false,
"positionClass": "toast-top-full-width",
"onclick": null,
"showDuration": "300",
"hideDuration": "1000",
"timeOut": "5000",
"extendedTimeOut": "1000",
"showEasing": "swing",
"hideEasing": "linear",
"showMethod": "fadeIn",
"hideMethod": "fadeOut"
};
$.ajax({
	url: "http://themes.laborator.co/xenon/data/login-check.php",
	method: 'POST',
	dataType: 'json',
data: {
	do_login: true,
	nomEmploye: $(form).find('#nomEmploye').val(),
	prenomEmploye: $(form).find('#prenomEmploye').val(),
	adresseEmploye: $(form).find('#adresseEmploye').val(),
	cinEmploye: $(form).find('#cinEmploye').val(),
	loginEmploye: $(form).find('#loginEmploye').val(),
	mpEmploye: $(form).find('#mpEmploye').val(),
},
success: function(resp)
{
	show_loading_bar({
	delay: .5,
	pct: 100,
finish: function(){

if(resp.accessGranted)
{
	window.location.href = '#';
}
else
{
toastr.error("You have entered wrong password, please try again. User and password is <strong>demo/demo</strong> :)", "Invalid Login!", opts);
$(form).find('#mpEmploye').select();
}
}
});
}
});
}
});
// Set Form focus
$("form#login .form-group:has(.form-control):first .form-control").focus();
});
</script> 
<div class="errors-container"></div> 
<form method="post" class="login-form fade-in-effect"> 
<div class="login-header"> 
<a href="#" class="logo"> 
<img src="assets/images/logo%402x.png" alt="" width="80" /> 
<span>Sign in</span>
 </a> 
 <p>Cher Employee, inscrivez-vous pour accéder à la zone d'administration!</p> 
 </div> 
 <div class="form-group">
  <label class="control-label" for="nomEmploye">Nom</label>
   <input type="text" class="form-control input-dark" name="nomEmploye" id="nomEmploye" autocomplete="off" /> 
   </div> 
   <div class="form-group"> 
   <label class="control-label" for="prenomEmploye">Prenom</label>
    <input type="text" class="form-control input-dark" name="prenomEmploye" id="prenomEmploye" autocomplete="off" />
     </div> 
     <div class="form-group">
  <label class="control-label" for="adresseEmploye">Adresse</label>
   <input type="text" class="form-control input-dark" name="adresseEmploye" id="adresseEmploye" autocomplete="off" /> 
   </div> 
   <div class="form-group"> 
   <label class="control-label" for="cinEmploye">CIN</label>
    <input type="text" class="form-control input-dark" name="cinEmploye" id="cinEmploye" autocomplete="off" />
     </div>
     <div class="form-group">
  <label class="control-label" for="loginEmploye">Login</label>
   <input type="text" class="form-control input-dark" name="loginEmploye" id="loginEmploye" autocomplete="off" /> 
   </div> 
   <div class="form-group"> 
   <label class="control-label" for="mpEmploye">Mot De Passe</label>
    <input type="password" class="form-control input-dark" name="mpEmploye" id="mpEmploye" autocomplete="off" />
     </div>
     <div class="form-group"> 
     <button type="submit" name="signin" class="btn btn-dark btn-block text-left">
     <i class="fa-lock"></i>
		Sign In
		</button> 
		</div>
		 
			</form> 
			
			 </div> 
			 </div> 
			 </div> 
			 <script src="assets/js/bootstrap.min.js" id="script-resource-1"></script> 
			 <script src="assets/js/TweenMax.min.js" id="script-resource-2"></script> 
			 <script src="assets/js/resizeable.js" id="script-resource-3"></script> 
			 <script src="assets/js/joinable.js" id="script-resource-4"></script>
			  <script src="assets/js/xenon-api.js" id="script-resource-5"></script>
			   <script src="assets/js/xenon-toggles.js" id="script-resource-6"></script>
			    <script src="assets/js/jquery.validate.min.js" id="script-resource-7"></script>
			     <script src="assets/js/toastr.min.js" id="script-resource-8"></script>
			     
			      <script src="assets/js/xenon-custom.js" id="script-resource-9"></script> 
			      
 </body> 
</html>