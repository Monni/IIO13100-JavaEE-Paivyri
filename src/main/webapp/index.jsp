<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Ruokap�iv�kirja</title>
	<link rel="stylesheet" href="/css/bootstrap.min.css" />
	<link rel="stylesheet" href="/css/style.css" />
	<link href="https://fonts.googleapis.com/css?family=Ranga" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="<c:url value="https://fonts.googleapis.com/css?family=Ranga" />" media="all" />
	<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
</head>
<body>
	<div id="mainContainer" class="contentBox">
		<div>
			<h1 class="centeredHeader">Ruokap�iv�kirja</h1>
		</div>
		<div class="container">
			<div class="container">
				<div class="row">
					<div class="col-md-8">
						<div>
							<p class="basicText">	
								Ruokap�iv�kirja on suunniteltu auttamaan sy�misen seurantaa. Sy�misrytmej� seuraamalla voidaan parantaa
								treenituloksia. 
								Ruokap�iv�kirjassa on mahdollista tallentaa omia aterioida ja niiden ravintopitoisuuksia. 
								Lis�ksi palvelu tarjoaa valmiiksi laskettuja keskiarvoja ja ruokarytmej� sy�tt�miesi tietojen perusteella.
							</p>
							<form action="/save">
								  <p class="basicText">Lis�� uusi ruokailu:</p>
								  <input type="text" name="kuka" value="" placeholder="Kuka s�i?" required>
								  <input type="date" name="pvm" value="" placeholder="P�iv�m��r�" required>
								  <input type="time" name="klo" value="" placeholder="Kellonaika" required>
								  <input type="text" name="ruoka" value="" placeholder="Mit� s�it?" required>
								  <br>
								  <br>
								  <input type="number" name="ruoanMaara" value="" placeholder="Ruoan m��r� (g)" required>
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
								  <p class="basicText">K�ytt�j�n nimi:</p>
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
							<h2 class="centeredSmallHeader">Haetun k�ytt�j�n tietoja</h2>
						</div>
					</div>
					<div class="row">
						<div class="col-md-6">
							<h3 class="centered basicText">Ateriakoko & sy�misrytmi</h3>
							<br>
							<h4 class="basicText" id="ateriakoko">Keskim��r�inen ateriakoko: ${ruokailuMedianModel.medianAteriakoko} g</h4>
							<h4 class="basicText" id="ateriatPaivassa">Aterioita p�iv�ss�:</h4>
							<h4 class="basicText" id="syomisrytmi">Keskim��r�inen ateriav�li:</h4>
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