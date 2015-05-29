<%@ page import="jeeproject.bean.*"%>
<%@ page import="jeeproject.hibernate.dao.*"%>
<%@ page import="jeeproject.dao.*"%>
<%@ page import="jeeproject.service.*"%>
<%@ page import="java.util.List" %>
<%@ page import="org.hibernate.Session" %>

<% Employe employe = (Employe) request.getSession().getAttribute("employe");
	System.out.println("employeeeee        "+employe);
	if (employe == null) {
		System.out.println("pas d'utilisateur");
		response.sendRedirect("login");
	} else {
		HibernateConnexion hc = (HibernateConnexion) request.getSession().getAttribute("hc");
		Session se = (Session) request.getSession().getAttribute("session");
		System.out.println("session mrigla");
		
		System.out.println("hhhhhhhhhhcccccccccccc======> "+hc );
		System.out.println("Sesssssssioooooooooonnnnnn======> "+se );
		
		EmployeDao ed = new EmployeDao(se);
		ArticleDao artd = new ArticleDao(se);
		
		
		System.out.println("logiiiiiiiiiiiiiiiiiiinn "+employe.getLoginEmploye());
        Employe emp = (Employe)ed.search(employe.getLoginEmploye());%>
       
<!DOCTYPE html> <html lang="en"> 
<!-- Mirrored from themes.laborator.co/xenon/blank/sidebar/ by HTTrack Website Copier/3.x [XR&CO'2014], Fri, 22 May 2015 10:24:18 GMT -->
<head> 
<meta charset="utf-8"> 
<meta http-equiv="X-UA-Compatible" content="IE=edge"> 
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
 <meta name="description" content="Xenon Boostrap Admin Panel" />
	<meta name="author" content="Laborator.co" /> 
	<title>Xenon - Blank Page</title> 
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
				 <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries --> <!--[if lt IE 9]> <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script> <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script> <![endif]--> <!-- TS1432290118: Xenon - Boostrap Admin Template created by Laborator -->
					</head>
					 <body class="page-body">
					 <!-- Profiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiile--> 
					<div class="settings-pane">
						<a href="#" data-toggle="settings-pane" data-animate="true">&times;</a>
						 <div class="settings-pane-inner"> 
						 <div class="row">
							<div class="col-md-4">
							 <div class="user-info"> 
							 <div class="user-image">
								<a href="#">
								 <img src="assets/images/user-4.png" class="img-responsive img-circle" />
									</a>
									 </div>
										<div class="user-details">
										 <h3> 
										 <a href="#"><% out.write(emp.getNomEmploye()+" "+emp.getPrenomEmploye()); %></a>
											<span class="user-status is-online"></span> 
											</h3>
											<p class="user-title"></p> 
											<div class="user-links"> 
											<a href="" class="btn btn-primary">Edit Profile</a> 
											<a href="" class="btn btn-success">Upgrade</a> 
											</div> 
											</div> 
											</div>
											 </div> 
											 
										   </div> 
										   </div> 
										   </div> 

<!--Fiiinnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn Profileeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee-->

										   <div class="page-container">
<!--  DeButttttttttttt Lefttttttttttt SideBarrrrrrrrrrrrrrrrrrrrrrrr-->
										   <div class="sidebar-menu toggle-others fixed">
										    <div class="sidebar-menu-inner">
										     <header class="logo-env"> <!-- logo -->
										      <div class="logo">
										       
										          <a href="#" class="logo-collapsed">
										           <img src="assets/images/logo-collapsed%402x.png" width="40" alt="" />
										            </a> 
										         </div> 
										         <div class="mobile-menu-toggle visible-xs"> <a href="#" data-toggle="user-info-menu">
										          <i class="fa-bell-o"></i> 
										          <span class="badge badge-success">7</span>
										           </a> 
										           <a href="#" data-toggle="mobile-menu"> <i class="fa-bars"></i> </a> 
										          </div> 
										          <div class="settings-icon"> 
										          <a href="#" data-toggle="settings-pane" data-animate="true"> 
										          <i class="linecons-cog"></i>
										           </a> 
										           </div> 
										           </header>
										    <ul id="main-menu" class="main-menu"> 
										            <li> 
																       <a href="Employe">
																       <i class="linecons-cog"></i>
																      	 <span class="title">Employées</span>
																       </a>
										            </li>
										            <li> 
										                    <a href="Client">
										                    	<i class="linecons-desktop"></i>
										                    	<span class="title">Clients</span>
										                    </a> 
										            </li>
					           					  <li class="active"> 
					           							  <a href="Article">
								           							  <i class="linecons-note"></i>
								           							  <span class="title">Articles</span>
					           							  </a> 
					    								  </li>
					                      <li>
					                          <a href="ArticleFamille">
					                          			<i class="linecons-star"></i>
					                           			<span class="title">Familles Articles</span>
					                          </a>
					                      </li>
					                      <li> 
					                          <a href="Commande">
							                          <i class="linecons-mail"></i>
							                          <span class="title">Commandes</span>
					                          </a> 
					                      </li>
												</ul> 
			                </div> 
			              </div> 


<!---\\\\\\\\\\\\\\\\\\   Fin     Left SIdeBar\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\-->			
    <div class="main-content"> 
    <!--\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\ Debut Barre de Navigation \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\ -->
		<nav class="navbar user-info-navbar" role="navigation">
	 <ul class="user-info-menu left-links list-inline list-unstyled">
	  <li class="hidden-sm hidden-xs"> 
	  <a href="#" data-toggle="sidebar">
	   <i class="fa-bars"></i> 
	   </a> 
	   </li> 
      
          
</ul> 
</ul> 
<ul class="user-info-menu right-links list-inline list-unstyled"> 
<li class="search-form">
 <form name="userinfo_search_form" method="get" action="#"> 
 <input type="text" name="s" class="form-control search-field" placeholder="Type to search..." />
  <button type="submit" class="btn btn-link"> <i class="linecons-search"></i>
   </button>
    </form>
     </li>
      <li class="dropdown user-profile">
       <a href="#" class="dropdown-toggle" data-toggle="dropdown"> 
       <img src="assets/images/user-4.png" alt="user-image" class="img-circle img-inline userpic-32" width="28" /> <span>
<% out.write(emp.getNomEmploye()+" "+emp.getPrenomEmploye()); %>
<i class="fa-angle-down"></i>
 </span>
  </a>
   <ul class="dropdown-menu user-profile-menu list-unstyled">
    
 <li>
  <a href="#profile">
   <i class="fa-user"></i>Profile</a>
 </li>  
 <li class="last">
  <a href="login.jsp"> 
  <i class="fa-lock"></i>
Logout
</a>
 </li>
  </ul>
   </li>
    
         </ul>
          </nav>
          <!--//////////////////////////////////////////////////////Contenu de code//////////////////////////////////////////////////////////-->
          <div class="page-title"> 
          <div class="title-env">
           <h1 class="title">Liste Des Articles</h1>
            
             </div>
              <div class="breadcrumb-env">
               <ol class="breadcrumb bc-1" > 
               <li> 
               <a href="acceuil.jsp">
               <i class="fa-home"></i>
               Home
               </a>
                </li>
                 <li> 
                 <a href="">Articles</a>
                  </li> 
                  <li class="active">
                   <strong>Liste Des Articles</strong> 
                  </li> 
                 </ol>
                  </div>
                   </div>
         <div class="tab-content">
           <div class="tab-pane active" id="all"> 
           <table class="table table-hover members-table middle-align"> 
           <thead> 
           	<tr>
           	  <th></th>
           	  
           	  <th>ID</th> 
           	  <th>Libelle</th> 
           	  <th>Reference</th>
           	  <th>Prix HTVA</th>
           	  <th>TVA</th> 
           	  <th>Quantit&egrave;</th>
           	  <th>Famille</th> 
           	  <th>Operations</th> 
           	  
           	</tr> 
           </thead>
           <tbody>
            <%
           List<Bean> arts = artd.listAll() ;
           for(int i=0;i<arts.size();i++){
           %> 
           	<tr>
           	 <td class="user-cb">
           	  <input type="checkbox" class="cbr" name="Articles-list[]" value="1" checked /> 
           	 </td>
           	 <td class="user-id">
           	  <div name="idArticle" class="id"><% out.write(((Article)arts.get(i)).getIdArticle()); %></div> 
          
           	 </td> 
           	 <td class="user-name">
				<div name="libelleArticle" class="name"><% out.write(((Article)arts.get(i)).getLibelleArticle()); %></div>
			 </td> 
           	 <td class="hidden-xs hidden-sm">
           	  <div name="referenceArticle" class="name"><% out.write(String.valueOf(((Article)arts.get(i)).getReferenceArticle())); %></div>
           	 </td> 
           	 <td class="hidden-xs hidden-sm">
           	  <div name="prixHtArticle" class="name"><% out.write(String.valueOf(((Article)arts.get(i)).getPrixHtArticle())); %></div>
           	 </td>
           	 <td class="user-id">
           	  <div name="tvaArticle" class="id"><% out.write(String.valueOf(((Article)arts.get(i)).getTvaArticle())); %></div> 
           	 </td> 
           	 <td class="user-id">
           	  <div name="quantiteArticle" class="id"><% out.write(String.valueOf(((Article)arts.get(i)).getQuantiteArticle())); %></div>
           	 </td>
           	 <td class="hidden-xs hidden-sm">
           	  <div name="nomFamille" class="name"><% out.write(String.valueOf(((Article)arts.get(i)).getFamilleArticle().getNomFamille())); %></div>
           	 </td>

           	 
			 <td class="action-links">
			  <form method="post">
			  <button name="modifier_art" value="<%out.write(((Article)arts.get(i)).getIdArticle());%>" class="edit" type="submit"> 
			  <i class="linecons-pencil"></i>
				Edit 
			  </button> 
			  <button name="supprimer_art" value="<%out.write(((Article)arts.get(i)).getIdArticle());%>" class="delete" type="submit"> 
			  <i class="linecons-trash"></i>
				Delete
			  </button> 
			  </form> 
			 </td>
			</tr> 
			<% } %>
		   </tbody> 
		  </table> 
		  <div class="row">
		   <div class="col-sm-6">
		     </div> 
		     <div class="col-sm-6 text-right text-center-sm"> 
		     <ul class="pagination pagination-sm no-margin">
		      <li>
		       <a href="#">
		        <i class="fa-angle-left"></i>
		       </a> 
		      </li> 
		      <li class="active">
		       <a href="#">1</a> 
		      </li> 
		      <li>
		       <a href="#">2</a> 
		      </li> 
		      <li>
		       <a href="#">3</a>
		      </li>
		      <li class="disabled"> 
		       <a href="#">4</a> 
		      </li> 
		      <li> 
		       <a href="#">5</a> 
		      </li> 
		      <li>
		       <a href="#">6</a>
		      </li> 
		      <li>
		       <a href="#"> 
		       	<i class="fa-angle-right"></i>
		       </a>
		      </li> 
		    </ul> 
		   </div> 
		  </div>
		 </div>
		 </div>
           <br />
          <!--//////////////////////////////////////////////////////Contenu de code//////////////////////////////////////////////////////////-->
           
           <footer class="main-footer sticky footer-type-1"> 
           <div class="footer-inner">
            <div class="footer-text">

 </div>
  <div class="go-up">
   
      </div>
       </div>
        </footer>
        </div> 
        <!-- TS143229011811566: Xenon - Boostrap Admin Template created by Laborator / Please buy this theme and support the updates --> 
       
                                          
                     </div> 
                     </div>
      
       <script src="assets/js/bootstrap.min.js" id="script-resource-1"></script>
        <script src="assets/js/TweenMax.min.js" id="script-resource-2"></script>
         <script src="assets/js/resizeable.js" id="script-resource-3"></script>
          <script src="assets/js/joinable.js" id="script-resource-4"></script>
           <script src="assets/js/xenon-api.js" id="script-resource-5"></script> 
           <script src="assets/js/xenon-toggles.js" id="script-resource-6"></script>
            <!-- JavaScripts initializations and stuff -->
             <script src="assets/js/xenon-custom.js" id="script-resource-7"></script>
               </body> 
<!-- Mirrored from themes.laborator.co/xenon/blank/sidebar/ by HTTrack Website Copier/3.x [XR&CO'2014], Fri, 22 May 2015 10:24:18 GMT -->
</html>
<%
	}
%>