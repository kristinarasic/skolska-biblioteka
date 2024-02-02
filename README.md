# skolska-biblioteka
Aplikacija za školsku biblioteku koju koristi bibliotekar kako bi vodio evidenciju o knjigama.
 

Školska biblioteka


CS202
Objekti i apstrakcija podataka

Projektna dokumentacija

31.01.2024.




Student: Kristina Rašić 5609
Mentori: Saradnik u nastavi Anđela Grujić


Sadržaj

1.	Predlog teme	3
2.	Opis funkcionalnosti	3
3.	Struktura aplikacije	4
4.	Korisničko uputstvo	6
5.	Zaključak	16
6.	Literatura	17

1.	Predlog teme

Sistem za školsku biblioteku. Korisnik (bibliotekar) se prijavljuje na aplikaciju, a nakon prijave, pojavljuje se meni sa raznim opcijama kao što su: pregled knjiga, dodavanje knjiga, pregled izdatih knjiga, dodavanje članova biblioteke, izdavanje knjige, razdužavanje knjige i pregled top 250 knjiga sa sajta goodreads.

2.	Opis funkcionalnosti

Korisnik nakon startovanja programa nailazi na početnu scenu za prijavljivanje na aplikaciju. Nakon što se uspešno prijavi, pojavljuje se meni sa različitim dugmićima. Korisnik zatim bira jedan od tih dugmića. Opcije koje korisnik ima su: 
1.	Dodavanje nove knjige – klikom na ovo dugme, otvara se novi prozor sa textBoxovima za unos podataka o knjizi,  nakon što je korisnik uneo podatke, klikće na dugme unesi knjigu i program mu zatim javlja da li je uspešno dodao knjigu ili je nevalidno uneo neki podatak.
2.	Dodavanje novog člana – klikom na ovo dugme, otvara se novi prozor sa textBoxovima za unos podataka o novom članu, nakon što korisnik unese podatke, klkće na dugme unesi član i program mu zatim javlja da li je uspešno dodao člana ili je uneo neki nevalidan podatak.
3.	Prikaz svih knjiga – klikom na ovo dugme, korisnik se susreće sa ekranom na kom su izlistane sve knjige sa njihovim podacima.
4.	Prikaz izdatih knjiga – klikom na ovo dugme, korisnik se susreće sa ekranom na kom su izlistane sve knjige sa njihovim podacima.
5.	Izdavanje knjige – klikom na ovo dugme, otvara se prozor sa dva comboBox-a gde se na jednom bira knjiga koju izdaje bibliotekar a na drugom se bira član biblioteke.
6.	Razduživanje knjige – klikom na ovo dugme, otvara se prozor sa jednim comboBox-om iz kog korisnik bira knjigu koju želi da razduži.

3.	Struktura aplikacije
Prikaz podele klasa:
 Projekat je podeljen u 8 paketa:
 
•	books > addBook, addBookMethod, Book, BookList, BookListMethod
•	database > database
•	exceptions > exceptions, invalidLoginException
•	IssuedBooks > bookcopy, borrowed, IssueBook, IssueBookMethod, IssuedBookList,IssuedBookListMethod, releseHold, releseHoldMethod
•	login > login, loginMethods, user, menu
•	main > main
•	members > addMember, addMemberMethod, member
•	webScraping > webScraping, webScrapingMethod
Klase:
•	addBook
•	addBookMethods
•	Book
•	BookList
•	BookListMethod
•	database
•	exceptions
•	invalidLoginException
•	bookcopy
•	borrowed
•	IssueBook
•	IssueBookMethod
•	IssuedBookList
•	IssuedBookListMethod
•	releseHold
•	releseHoldMethod
•	login
•	loginMethods
•	menu
•	user
•	main
•	addMember
•	addMemberMethod
•	member
•	webScraping
•	webScrapingMethod
4.	Korisničko uputstvo

Korisnik kada pokrene program vidi početnom scenom. Na početnoj sceni vidi Log-in gde postoje dva polja za unos korisničkog imena i šifre.
 
Korisnik unosi svoje podatke i program ga obaveštava o tome da li su podaci validni.
 
 Ako je validacija prijave uspešna, prikazuje se sledeća scena, meni.
 
Na meniju može da izabere jednu od 7 opcija koje su ponuđene.
1.	Ukoliko korisnik želi da doda novu knjigu u sistem, bira prvo dume.
 
Nakon toga se otvara nova scena sa textField-ovima koje korisnik treba popuniti. Nakon što unese sve podatke, klikće na dugme Add Book i ukoliko su podaci validni, program ga obaveštava da je uneo knjigu u sistem i vraća se na meni.
 

2.	Ukoliko korisnik želi da doda novog člana u sistem, bira drugo dume.
 
Nakon toga se otvara nova scena sa textField-ovima koje korisnik treba popuniti. Nakon što unese sve podatke, klikće na dugme Add member i ukoliko su podaci validni, program ga obaveštava da je uneo novog člana u sistem i vraća se na meni.
 
3.	Ukoliko korisnik želi da pregleda sve knjige koje su izdate, bira treće dume.
 
Kada korisnik završi sa pregledom izdatih knjiga, klikom na dugme go back, vraća se na stranicu meni.
4.	Ukoliko korisnik želi da pregleda sve knjige koje se nalaze u biblioteci, bira ćetvrto dume.
 
Kada korisnik završi sa pregledom knjiga, klikom na dugme go back, vraća se na stranicu meni.
5.	 Ukoliko korisnik želi da izda knjigu nekom članu, bira peto dugme.
 

Na ekranu može da vidi dva combo box-a, u levom bira knjigu, a u desnom bira korisnika. Kada je izabrao opcije koje je hteo, klikom na dugme issue the book, on u sistem unosi da je ta knjiga izdata. Program mu zatim javlja da li je uspešno izdao knjigu.
 
Klikom na dugme go back, vraća se na meni.
6.	Ukoliko korisnik želi da oslobodi izdatu knjigu ,bira šesto dugme. 
 
Korisnik bira koju knjigu želi da oslobodi i zatim klikće na dugme relese hold. Ukoliko je uspešno izbrisana iz sistema, program javlja korisniku o uspešnosti toga.
 
Kada je korisnik zavrsio sa oslobađanjem svih knjiga, klikom na dugme go back, vraća se na meni.
7.	Ukoliko korisnik želi da pogleda top 250 knjiga sa sajta goodreads.com, bira sedmo dugme.
 
Otvara se scena na kojoj se prikazuju naslovi I ocene svih knjiga sa tog sajta. Kada korisnik završi sa pregledom knjiga, klikom na dugme go back odlazi nazad na meni.

5.	Zaključak

Sistem za školsku biblioteku. Korisnik se prijavljuje na sistem, a nakom prijave se susreće sa više opcija, da doda novu knjigu, novog člana, da pregleda knjige i izdate knjige, da izda ili oslobodi knjigu i da pregleda top 250 knjiga sa stranice goodreads.
Za dalje unapređenje aplikacije dodala bih vreme izdavanja knjiga, optimizaciju koda, slike koje vizuelno predstavljaju knjige koje se nalaze u biblioteci.

6.	Literatura

LAMS: http://lams.metropolitan.ac.rs:8080/lams
Geeks for geeks: https://www.geeksforgeeks.org
StackOverflow: https://stackoverflow.com
W3schools: https://www.w3schools.com/java

