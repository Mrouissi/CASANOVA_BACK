# CASANOVA_BACK

## Docs

- [Spring Boot](https://spring.io/quickstart)
- [Docker](https://docs.docker.com/)

## Les classes

Utilité des dossiers :
 - model :  
   Se trouve les classes des entités (qui génere la bdd).
 - repository :  
   Il y a les classes qui servent à créer des requêtes vers la bdd.
 - restcontroller :  
   Les classes qui créent l'API REST appelé par le Front-End 

## Docker
### Commandes
Pour générer le .jar du projet dans le backend :
> mvn clean install

Pour créer une image docker
> docker build -t <hub-user>/<repo-name>[:\<tag\>] .

Puis on peut lancer les images avec :  
> docker run -d -p 8080:80 <hub-user>/<repo-name>[:\<tag\>]  

pour le backend et :  
> docker run -d -p 80:80 <hub-user>/<repo-name>[:\<tag\>]  

pour le frontend.

## Email 
Dans application.properties :
> spring.mail.username =
> spring.mail.password =

sont à compléter. On peut aussi changer les autres infos car le stmp de gmail est utilisé par défaut.  

Dans la classe EmailSenderService on veut aussi remplir la constante 'sendFromMail' qui doit être le mail utilisé pour envoyé les mails.

## BDD
Une fois la bdd générer par Spring, on peut y créer les comptes.
Pour entrer directement un mot de passe il faut le crypter avec [bcrypt](https://www.bcrypt.fr/)
