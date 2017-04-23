<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Ruokapäiväkirja</title>
	<link rel="stylesheet" href="/css/bootstrap.min.css" />
	<link rel="stylesheet" href="/css/style.css" />
	<link href="https://fonts.googleapis.com/css?family=Ranga" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="<c:url value="https://fonts.googleapis.com/css?family=Ranga" />" media="all" />
	<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
</head>
<body>
	<div id="mainContainer" class="contentBox">
		<div>
			<h1 class="centeredHeader">Ruokapäiväkirja</h1>
		</div>
		<div class="container">
			<div class="container">
				<div class="row">
					<div class="col-md-8">
						<div>
							<p class="basicText">	
								Ruokapäiväkirja on suunniteltu auttamaan syömisen seurantaa. Syömisrytmejä seuraamalla voidaan parantaa
								treenituloksia. 
								Ruokapäiväkirjassa on mahdollista tallentaa omia aterioida ja niiden ravintopitoisuuksia. 
								Lisäksi palvelu tarjoaa valmiiksi laskettuja keskiarvoja ja ruokarytmejä syöttämiesi tietojen perusteella.
							</p>
							<form action="/save">
								  <p class="basicText">Lisää uusi ruokailu:</p>
								  <input type="text" name="kuka" value="" placeholder="Kuka söi?" required>
								  <input type="date" name="pvm" value="" placeholder="Päivämäärä" required>
								  <input type="time" name="klo" value="" placeholder="Kellonaika" required>
								  <input type="text" name="ruoka" value="" placeholder="Mitä söit?" required>
								  <br>
								  <br>
								  <input type="number" name="ruoanMaara" value="" placeholder="Ruoan määrä (g)" required>
								  <input type="number" name="kalorit" value="" placeholder="Kalorit per 100g" required>
								  <input type="number" name="hiilarit" value="" placeholder="Hiilihydraatit per 100g">
								  <input type="number" name="proteiinit" value="" placeholder="Proteiini per 100g">
								  <br>
								  <br>
								  <input type="number" name="rasvat" value="" placeholder="Rasvat per 100g">
								  
								  <br>
								  <br>
								  <div>
									  <input type="submit" value="Tallenna ruokailu" src="save/">
								  </div>
							</form>
						</div>
					</div>
					<div class="col-md-1">
						
					</div>
					<div class="col-md-3">
						<div class="rightSidebar">
							<h3 class="basicText">Hae tuloksia</h3>
							<form action="/findbyuser">
								  <p class="basicText">Käyttäjän nimi:</p>
								  <input type="text" name="firstname" value="" placeholder="Tepi" required>
								  <br>
								  <br>
								  <input type="submit" value="Hae">
							</form>
						</div>
					</div>
				</div>
				<div id="stats">
					<div class="row">
						<div class="col-md-12">
							<h2 class="centeredSmallHeader">Haetun käyttäjän tietoja</h2>
						</div>
					</div>
					<div class="row">
						<div class="col-md-6">
							<h3 class="centered basicText">Ateriakoko & syömisrytmi</h3>
							<br>
							<h4 class="basicText" id="ateriakoko">Keskimääräinen ateriakoko: ${ruokailuMedianModel.medianAteriakoko} g</h4>
							<h4 class="basicText" id="ateriatPaivassa">Aterioita päivässä:</h4>
							<h4 class="basicText" id="syomisrytmi">Keskimääräinen ateriaväli:</h4>
						</div>
						<div class="col-md-6">
							<h3 class="centered basicText">Viikon ravintoaineet</h3>
							<div id="piechart_3d"></div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script>
		google.charts.load("current", {packages:["corechart"]});
    	google.charts.setOnLoadCallback(drawChart);
    	
    	function drawChart() {
            var data = google.visualization.arrayToDataTable([
              ['Task', 'Ravintoaineet'],
              ['Proteiini', ${ruokailuMedianModel.medianProteiinit}],
              ['Hiilihydraatit', ${ruokailuMedianModel.medianHiilihydraatit}],
              ['Rasvat', ${ruokailuMedianModel.medianRasvat}]
            ]);

            var options = {
       	      legend: {
       	        textStyle: { color: 'white' }
       	      },
              title: '',
              backgroundColor: 'transparent',
              is3D: true,
            };

            var chart = new google.visualization.PieChart(document.getElementById('piechart_3d'));
            chart.draw(data, options);
          }
	</script>
</body>
</html>