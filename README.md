

Étape 7 : Sur IntelliJ : Run -> Edit Configurations -> + Maven Run
Étape 13
    1) Grâce au getmapping @GetMapping("/greeting")
    2) Grâce au return gretting qui retourne la vue
    3) Grâce à cette commande model.addAttribute("nomTemplate", nameGET);

Étape 16 : Sur IntelliJ pour avoir les getter et setter Alt + Inser

Étape 17 : Address est apparu dans la base de données avec ses variables ID/CONTENT/CREATION

Étape 18 : Grâce au @Entity au dessus de la classe il reconnait que c'est une table

Étape 20 : Le contenu de **data.sql** est apparu dans la table ADDRESS

Étape 23 :  Lie automatiquement la methode avec les installations de dépendances de Spring.

Étape 30 : Ajout de 
		< dependency >
			< groupId >org.webjars< /groupId >
			< artifactId >bootstrap< /artifactId >
			< version >3.2.0< /version >
		< /dependency >
	   dans le pom.xml

TP4

Étape 6
1) Il faut une clé API pour y accéder. Cette clé est limité en nombre d'appel dans la journée. 
2) Pour avoir la météo du jour aux coordonnées GPS données il faut appeler 'https://api.meteo-concept.com/api/forecast/daily/0?token=MON_TOKEN&latlng=COORD_GPS'. 
3) Il faut utiliser la méthode HTTP GET pour récupérer les données de l'API. 
4) Pour passer des paramètres d'appel il suffit de mettre un ? à la fin de l'opération et de rajouter NOM_ATTRIBUT=val avec une & entre chaque attribut. 
5) La température du lieu visé par les coordonnées GPS est trouvable dans forecast->temp2m 
6) La prévision de météo du lieu visé par les coordonnées GPS est trouvable dans forecast->weather