<h1>Repository fn_backend</h1>
<h4>Tech stack : Java, Spring boot, Postgres SQL</h4>
<h5>Setup details and environmental requirements</h5>
<div>* 1.environmental requirements : PostgresSQL, and Java </div>
<div>* 2.Configure the backend application with Java, postgres SQL(default database name postgres, with default username and password , that is postgres, start the java application for table creation)</div>
<div>* 3.Backend jar file is attached in this repo(here 🚴‍♀️ https://drive.google.com/file/d/1B_0TZXtjYU09FUh1IBQjMe3IAvYIWur9/view?usp=drive_link), with configuration from point 2</div>
<div>* run the .jar file with following command
command -> nohup java -jar filename.jar</div>
<div>* For further setup details, check fn_frontend repos->readme->software configuration</div>
<div>* By deafult the backend runs at 8080 port, and even frontend is configured for the same port in the localhost</div>
<h2>API: Billing api</h2>
<p>Configure the backend application with Java, postgres SQL(default database postgres, with username and password being postgres)</p>
<p>Once the backend is up and running, your will be able to reach the Rest API, https://your-ip:port/api/v1/invoice/PriceCalculator?kms=1&hours=1&dayOfWeek=0&WeightingHours=1</p>
<p>GET Request</p>
<p>parameter : Takes in parameter kms,hours,dayOfWeek, and WeightingHours(similiar to from UI, refer page 1.Bill</p>
<p>Response : response with a string value of amount calculated using formula(from notion page)</p>
<h4>Api Image</h4>
<Img src="api.png"/>
</br>
</br>
<h2>Some new Testing outputs</h2>
</br>
<div>configurations before the   tests</div>
<img src="configsForBackendTest.JPG"/>
</br>
<div>1</div>
<img src="test1.JPG"/>
</br>
<div>2</div>
<img src="test2.JPG"/></br>
<div>3</div>
<img src="test3.JPG"/></br>
<div>4</div>
<img src="test4.JPG"/></br>
<div>5</div>
<img src="test5.JPG"/>
</br>
<div>6</div>
<img src="testFortuedayDBPconfig.JPG"/>

