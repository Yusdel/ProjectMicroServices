### VSC Shortcuts 
 **https://code.visualstudio.com/shortcuts/keyboard-shortcuts-windows.pdf**
 
### AngularJS Architecture
 **https://github.com/toddmotto/angularjs-styleguide#modular-architecture**

### AngularJS Best Practice
 **https://www.toptal.com/angular-js/tips-and-practices**


### Directives
**https://www.3pillarglobal.com/insights/angularjs-understanding-directive-scope/**

 ### Code examples

 - https://demo.mobiscroll.com/v4/angularjs/cards/video#

 - https://material.angularjs.org/latest/getting-started

 - https://v7.material.angular.io/components/menu/overview

 - https://yeoman.io/generators/

 - https://www.youtube.com/watch?v=FIbLHrfO0tU

 - https://github.com/angular/angular-seed

 - https://getbootstrap.com/docs/5.0/getting-started/introduction/

## AngularJS Material
 *https://github.com/angular/bower-material/#installing-angularjs-material*

## AngularJS Animate
 *https://docs.angularjs.org/api/ngAnimate*

## AngularJS Aria
 *https://www.npmjs.com/package/angular-aria*

## AngularJS Messages
 *https://docs.angularjs.org/api/ngMessages#!*

## CodeLab Tutorial
 *https://codelabs.developers.google.com/codelabs/mdc-101-web/#1*

## tutorials

 - https://www.youtube.com/watch?v=6weXKhZ5G08&list=PLGeQyNDhU6x0jHcgYEl4fhpuTUgOY4X-x&index=13


## Base AngularJS
 Il framework si basa su *direttive* ossia *marcatori* che definiscono il comportamento che deve avere un elemento HTML. Le direttive si applicano quindi ai *tag HTML*, come body, div, ... e anche al tag html stesso. Tutte le direttive iniziano con **ng-**. Le direttive possono essere assegnate come attributo, come elemento o come classi css.

**ng-app**: *Definisce il contesto della nostra applicazione. Indica ad Angular nella fase di inizializzazione quale sia l'elemento della pagina HTML che deve prendere come elemento radice, root.*

**ng-model**: *Usato sugli elementi di input, definisce un modello di dati associato alla casella di testo. Associa al campo input una variabile con id di riferimento ng-model="var_name". Per la stampa di una variabile si usano l'annotazione {{ var_name }}.*

**$scope**: *Oggetto con le propriet?? e i metodi disponibili, ?? disponibile sia per le view sia per i controller. ?? una variabile locale.*

**$rootScope**: *Definisce una variabile Globale.*

**gn-if, ng-switch**

**ng-cloak** *visualizza l'elemento solo a compilazione avvenuta durante il caricmento della pagia, evita lo sfarfallio.*

**ng-class**: *Permette di impostare dinamicamente delle classi css ad un elemento HTML.*

**ng-click**: *cattura l'evento di click "<button ngClick="myFunc()"></button>"*

**ng-repeat, ng-options**: *Permette di ciclare un oggetto dinamicamente all'interno dell'HTML. Ng-repeat definisce inoltre una variabile di scope ($index) che tiene traccia dell'indice corrente. Inseribile all'interno di un tag <select> per la popolazione del campo.*

    <li ng-repeat="row in elenco">{{row.nome}}</li>

 *Oggetto nel controller*

    $scope.elenco = [{nome:'John', cognome: 'Yappi'}, {nome:'Algro', cognome: 'Gubbro'}, ... ];

*Per evitare il primo elemento blank*

    $scope.selectedItem = $scope.elenco[0];

*Nel tag <select>, la variabile selectedItem rappresenta la scelta del campo.*

    <select ng-model="selectedItem">
        <option ng-repeat="row in elenco" value="row.nome">{{row.cognome}}</option>
    </select>

 *Il blocco select ?? ottimizzabile come segue:*

    <select ng-model="selectedItem" ng-options="row.nome group by row.cognome for row in elenco"></select>

 *In questo secondo caso viene assegnato a selectedItem l'intera "row"/oggetto e non solo il nome come sopra. Inoltre viene visualizzato il nome e l'array viene raggruppato, group by, per cognome.*

**Filtrare i dati**
 *ordine naturale*

    <option ng-repeat="row in elenco | orderBy:'cognome'" value="row.nome">{{row.cognome}}</option>

 *ordine inverso*

    <option ng-repeat="row in elenco | orderBy:'-cognome'" value="row.nome">{{row.cognome}}</option>

 *row number limit*

    <option ng-repeat="row in elenco | orderBy:'-cognome' | limitTo=5" value="row.nome">{{row.cognome}}</option>

 *filter:{} nel caso seguente: elenco dei nomi che contengono la lettera 'r'*

    <option ng-repeat="row in elenco | filter:{nome = 'r'}" value="row.nome">{{row.cognome}}</option>

 *filter:{} nel caso seguente: elenco degli oggetti/row che contengono la lettera 'r'*

    <option ng-repeat="row in elenco | filter:'r'" value="row.nome">{{row.cognome}}</option>

**filtri standard**

    {{"PrImO TesTiO" | uppercase | lowercase}} *I filtri vengono applicati in sequenza, quindi prima applica upper e poi lower!*
    {{"Secondo Filtro" | limitTo:7}} *first 7 characters*
    {{3.5478955445221554892 | limitTo:15}} *first 15 characters*
    {{3.17489517986415646987 | number:15}} *same of limitTo*
    {{3.17489517986415646987 | number:0}} *non stampa le cifre decimali*
    {{120.48 | currency}} *per le valute, di default viene stampato il dollaro $*
    {{120.48 | currency:"???":0}} *valuta euro senza cifre decimali*
    {{data | date:"fullDate"}}
    {{data | date:"longDate"}}
    {{data | date:"medium"}}
    {{data | date:"short"}}
    {{data | date:"shortTime"}}
    {{data | date:"EEEE dd-MM-yyyy HH:mm:ss"}}

**Filtri Personalizzati**
 *Si dichiarano come i controllers*

    <p>{{test our filter | myFilter}}</p>

    angular.module("myApp", [])
        .filter("myFilter", function (){
            return function(text){
                // do something with the 'text' and return it
            }
        })

# Services

 *Sono dei componenti indipendenti dall'interfaccia utente, consentono di implementare la business logic. Si occupano quindi di recuperare ed elaborare i dati da trasmettere alle view (mediante i controller) per la visualizzazione.*
 *In breve: si crea un blocco di codice come servizio, che pu?? essere richiamato all'interno dell'applicazione. I servizi sono oggetti "singleton" esiste quindi una sola istanza poi accessibile da tutti i componenti.*

## Service Class

 *Nella chiamata ai servizi definiti mediante "service", Angular fornisce l'istanza della funzione associata al servizio. Nel caso sotto una istanza della funzione somma.*

    angular.module("myApp", [])
        .service("myService", function (){
            this.somma = function(a, b){
                return a+b;
            }
        })

    angular.module("myApp", [])
        .controller("myCtrl", function($scope, myService){
            $scope.x = myService.somma(4, 5);
        })

## Factory Class

**[method B: factory]** *Quando si usano servizi definiti mediante il metodo "factory", angular fornisce direttamente il valore restituito dall'esecuzione della funzione.*

    angular.module("myApp", [])
        .factory("myService2", function (){
            this.somma = function(a, b){
                return a+b;
            }
        })
 
*call service*

    angular.module("myApp", [])
    .controller("myCtrl", function($scope, myService2){
        $scope.y = myService2(5, 7);
    })

*Il modo pi?? comune di utilizzare questa "classe" ?? quella di intermediatore per il passaggio dei dati tra i moduli! Nell'esempio seguente abbiamo 2 moduli, e un modulo Factory che far?? da contenitore dati per il passaggio.*

*Factory Module*

    angular.module("myFactory", [])
        .factory("Info", function(){
            let savedInfo = {};

            function set(data){ savedInfo = data };
            function get() { return savedInfo };

            return { set: set, get: get }
        })

*modulo A contenitore della <funzione> onclick che ci reindirizza al modulo B passandogli i dati*

    angular.module("A", ['myFactory'])
        .controller($scope, Info){
            $scope.getInfo = function(data) {
                Info.set(data);
                $location.path("/showInfo");
            }
        }

*modulo B chiamato dalla funzione getInfo mediante il redirect*

    angular.module("B", ['myFactory'])
        .controller($scope, Info){
            $scope.info = Info.get();
        }

**Note.** *Nell'uso di angular.module("app", []) ... le parentesi quadre vanno inserite solo la prima volta all'interno del singolo file, altrimenti va in conflitto. La seconda volta basta dichiarare: angular.module("app") ...*

# Directives

**Note:** *tipi di restrict: { 'E': element or tag, 'C': class, 'A': attribute, 'M': comment }*

## Element

    angular.module("<name od module>",[])
    .directive("<nome_direttiva>",function(){
        return {
            restrict: "E",
            replace: true, *rimuove il tag <nome_direttiva> lasciando solo il suo contenuto ossia il template*
            link: function(scope, element, options){
                scope.fullName = options.first + " " + options.last;
            },
            template: "<h2>nome completo: {{fullName}}</h2>" *templateUrl for file html*
        }
    })

**use** 

    <nome_direttiva data-first="Homer" data-last="Simpson"></nome_direttiva>

*Note. Nel passaggio di parametri come oggetto scope i nomi devono essere cos?? associati:*
*scope: { miaVarName = '=', miaVarName2 = '@' , ...}*
*<nome_direttiva mia-var-name="data" mia-var-name-2="data"></nome_direttiva>*

## Attribute

    angular.module("<name od module>",[])
    .directive("<nome_direttiva>",function(){
        return {
            restrict: "A",
            link: function(scope, element, options){
                scope.fullName = options.first + " " + options.last;
            },
            template: "nome completo: {{fullName}}"
        }
    })

**use** 

    <p <nome_direttiva>="" data-first="Homer" data-last="Simpson"></p>

## Class

    angular.module("<name od module>",[])
    .directive("<nome_direttiva>",function(){
        return {
            scope: {}, *or scope: true, per evitare che venga sovrascritto nel riutilizzo.*
            restrict: "C",
            link: function(scope, element, options){
                scope.fullName = options.first + " " + options.last;
            },
            template: "nome completo: {{fullName}}"
        }
    })

**use** 

    <p class="<nome_direttiva>" data-first="Homer" data-last="Simpson"></p>

**ng-model="Object.$"** *prende in considerazione tutti i campi dell'oggetto"*

**http service** *chiamate API, simile alle fetch*

    .controller("<nome_controller>", function($scope, $http){
        $http.get("<fetch_url>")
            .then(function(res){
                $scope.<nome_variabile> = res;
            })
    })

**$scope.$watch** *cattura ogni variazione dell'oggetto specificato, simile a onChange().*

*watch su variabili*

    .controller(<nome_ctrl>, function($scope){
        $scope.<name> = <value>;

        $scope.$watch('<name>', function(newVal, oldVal){
            *@param1 = nuovo valore della variabile in ascolto*
            *@param2 = vecchio valore della variabile in ascolto*
        })
    })

*watch su oggetti, di default il parametro di ascolto sugli oggetti ?? impostato a false!*

    .controller(<nome_ctrl>, function($scope){
        $scope.<name> = {<name_attr>: <value>};

        $scope.$watch('<name>', function(newVal, oldVal){
            *@param1 = nuovo valore della variabile in ascolto*
            *@param2 = vecchio valore della variabile in ascolto*
        }, true)
    })

# $scope.$digest/$apply

*La funzione $digest dello scope, itera tutti gli oggetti di eventuali data-binding e controlla se una delle variabili osservate ?? cambiata. Se il responso ?? positivo allora $digest chiama una funzione listener corrispondente che effettuer?? tutto il lavoro necessario, come la modifica di un testo HTML per aggiornare il nuovo valore della variabile controllata.*
*In pratica il $digest ?? la funzione che attiva l'aggiornamento del data-binding. Nell'esempio sotto riportato, ?? NECCESSARIO chiamare manualmente il refresh del data-binding, altrimenti l'evento di click sar?? catturato ma la pagina non verr?? aggiornata.*

*$apply accetta una funzione come parametro, e chiama il $digest.*

    .controller("myCtrl", function($scope){
        $scope.password = generatePassword();

        document.querySelector("<id_tag>"). addEventListener("click", function(){
            $scope.password = generatePassword();

            $scope.$digest(); // or $scope.$apply();
        })
    })

    function generatePassword(){
        //code
        return val;
    }

    $scope.$apply(function(){
        $scope.data.myVar = "another value";
    })

# $scope.on VS window.onload (On Load document)

    $scope.$on('$viewContentLoaded', function() {
        //call it here
    });

----------------------------------------------------------------

### $WATCH

*https://www.sitepoint.com/mastering-watch-angularjs/*

### SWAGGER

*https://swagger.io/tools/swagger-ui/download/*

### $q.defer or Q.defer() -> $q vs Q

*https://docs.angularjs.org/api/ng/service/$q#!*

### '@' '&' '=' '>'

*https://itorn.net/angularjs-symbols-and-in-custom-directives-scope-binding/*

# Exit from foreach

*https://masteringjs.io/tutorials/fundamentals/foreach-break*

### _.findWhere() & _.where

https://www.sitepoint.com/building-3d-rotating-carousel-css-javascript/

https://www.javatpoint.com/soapui

### $broadcast - $emit 

*https://stackoverflow.com/questions/29839917/when-to-use-scope-on-and-scope-emit-on-angular*