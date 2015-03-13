Deze opdracht gaat over het zoeken naar een kortst mogelijke uitweg uit een vierkante
ruimte die bezaaid is met obstakels. De ruimte kan voorgesteld worden als een rooster
van locaties. Een locatie waarop zich een obstakel bevindt is ontoegankelijk voor de
agent. De agent heeft zicht op de volledige ruimte en kan acht acties ondernemen, deze
komen elk overeen met het bewegen van 1 locatie naar een andere in één van de acht
windrichtingen. De agent kan niet op een locatie met een obstakel belanden of de ruimte
verlaten. Hieronder zie je een voorbeeld van een vierkante ruimte van dimensie 9. De
agent (label S) moet een weg vinden naar de uitgang (label G). De obstakels zijn de
locaties met een X. De kost om een horizontale of vertikale beweging te maken is 1; de
kost om een schuine beweging te maken is vierkantswortel 2.
```
| | |X| |G| | | | |
|X| |X|X|X|#| |X|X|
| | | | |#| | | | |
|X| | |X|#|X| | | |
|X| | |#| | | | | |
| | | |#| | | | | |
|X|X|X|#| | | | | |
|X|X|X|#| | | | | |
|S|#|#| | |X| | | |
```

Een mogelijk oplossing voor onze agent in dit voorbeeld is de volgende sequentie van
acties (aangegeven op het voorbeeld via #-tekens):
Oost – Oost – NoordOost – Noord – Noord – Noord – NoordOost – Noord – NoordOost - NoordWest

Merk op: deze oplossing heeft een padkost van 11.66
In een initiële toestand bevindt de agent zich in de linkerbenedenhoek van de ruimte, de
uitweg bevindt zich midden bovenaan en er zijn 25% willekeurig gekozen locaties niet
toegankelijk.
In deze opdracht ga je verschillende zoekstrategieën implementeren en vergelijken. Je
werkt hiervoor de gegeven basiscode in Java verder uit.