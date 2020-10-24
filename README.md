# b2b-ingestor
An attempt to build a sample CSV, TSV, XSL[X] (to be attempted) file processor. Aim is to read the csv/tsv/xsl(x) file along with its provided schema as TSV. Process and segregate valid and invalid records.

## Also aimed to have localized server logging using logback and cal10n.

Currently Unit test provides input file name along with its releated schema file name and application looks for those files at a given folder on your machine - folder path is configured in ***Constants class*** . You may like to tweak Unit test and application per your choice of test setup.

## When locale is GERMANY:
```
Running com.vikash.fp.application.ApplicationTest
14:06:23.890 [main] INFO com.vikash.fp.application.Application - Verarbeitungsschemadatei: officeSchema.csv und Eingabedatei: offices.csv
14:06:24.100 [main] INFO com.vikash.fp.interfaces.AbstractFileReader - Schema-Verst??e gefunden f?r:
14:06:24.100 [main] INFO com.vikash.fp.interfaces.AbstractFileReader - [Office [id=O2, name=null, address=Mumbai, primarydoctor=D3]]
14:06:24.100 [main] INFO com.vikash.fp.application.Application - Aufzeichnungen gut f?r die weitere Verarbeitung:
14:06:24.100 [main] INFO com.vikash.fp.application.Application - Office [id=O1, name=Office 1, address=Pune, primarydoctor=D5]
14:06:24.101 [main] INFO com.vikash.fp.application.Application - Office [id=O3, name=Office 3, address=Delhi, primarydoctor=D4]
14:06:24.101 [main] INFO com.vikash.fp.application.Application - Office [id=O4, name=Office 4, address=null, primarydoctor=D5]
14:06:24.101 [main] INFO com.vikash.fp.application.Application - Office [id=O5, name=Office 5, address=Indore, primarydoctor=D1]
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
14:06:24.102 [main] INFO com.vikash.fp.application.Application - Verarbeitungsschemadatei: doctorSchema.csv und Eingabedatei: doctors.csv
14:06:24.105 [main] INFO com.vikash.fp.interfaces.AbstractFileReader - Schema-Verst??e gefunden f?r:
14:06:24.105 [main] INFO com.vikash.fp.interfaces.AbstractFileReader - [Doctor [id=null, name=Doctor 4], Doctor [id=D8, name=null]]
14:06:24.106 [main] INFO com.vikash.fp.application.Application - Aufzeichnungen gut f?r die weitere Verarbeitung:
14:06:24.106 [main] INFO com.vikash.fp.application.Application - Doctor [id=D1, name=Doctor 1]
14:06:24.106 [main] INFO com.vikash.fp.application.Application - Doctor [id=D2, name=Doctor 2]
14:06:24.106 [main] INFO com.vikash.fp.application.Application - Doctor [id=D3, name=Doctor 3]
14:06:24.106 [main] INFO com.vikash.fp.application.Application - Doctor [id=D5, name=Doctor 5]
14:06:24.106 [main] INFO com.vikash.fp.application.Application - Doctor [id=D6, name=Doctor 6]
14:06:24.106 [main] INFO com.vikash.fp.application.Application - Doctor [id=D7, name=Doctor 7]
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
Tests run: 2, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.357 sec

Results :

Tests run: 2, Failures: 0, Errors: 0, Skipped: 0

```

## When locale is FRENCH:
```
Running com.vikash.fp.application.ApplicationTest
14:12:58.297 [main] INFO com.vikash.fp.application.Application - Traitement du fichier de sch?ma: officeSchema.csv et du fichier dentr?e: {1}
14:12:58.521 [main] INFO com.vikash.fp.interfaces.AbstractFileReader - Violations de sch?ma d?tect?es pour: 
14:12:58.521 [main] INFO com.vikash.fp.interfaces.AbstractFileReader - [Office [id=O2, name=null, address=Mumbai, primarydoctor=D3]]
14:12:58.521 [main] INFO com.vikash.fp.application.Application - Enregistrements bons pour un traitement ult?rieur:
14:12:58.521 [main] INFO com.vikash.fp.application.Application - Office [id=O1, name=Office 1, address=Pune, primarydoctor=D5]
14:12:58.521 [main] INFO com.vikash.fp.application.Application - Office [id=O3, name=Office 3, address=Delhi, primarydoctor=D4]
14:12:58.521 [main] INFO com.vikash.fp.application.Application - Office [id=O4, name=Office 4, address=null, primarydoctor=D5]
14:12:58.521 [main] INFO com.vikash.fp.application.Application - Office [id=O5, name=Office 5, address=Indore, primarydoctor=D1]
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
14:12:58.523 [main] INFO com.vikash.fp.application.Application - Traitement du fichier de sch?ma: doctorSchema.csv et du fichier dentr?e: {1}
14:12:58.526 [main] INFO com.vikash.fp.interfaces.AbstractFileReader - Violations de sch?ma d?tect?es pour: 
14:12:58.526 [main] INFO com.vikash.fp.interfaces.AbstractFileReader - [Doctor [id=null, name=Doctor 4], Doctor [id=D8, name=null]]
14:12:58.526 [main] INFO com.vikash.fp.application.Application - Enregistrements bons pour un traitement ult?rieur:
14:12:58.526 [main] INFO com.vikash.fp.application.Application - Doctor [id=D1, name=Doctor 1]
14:12:58.526 [main] INFO com.vikash.fp.application.Application - Doctor [id=D2, name=Doctor 2]
14:12:58.526 [main] INFO com.vikash.fp.application.Application - Doctor [id=D3, name=Doctor 3]
14:12:58.526 [main] INFO com.vikash.fp.application.Application - Doctor [id=D5, name=Doctor 5]
14:12:58.526 [main] INFO com.vikash.fp.application.Application - Doctor [id=D6, name=Doctor 6]
14:12:58.526 [main] INFO com.vikash.fp.application.Application - Doctor [id=D7, name=Doctor 7]
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
Tests run: 2, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.43 sec

Results :

Tests run: 2, Failures: 0, Errors: 0, Skipped: 0
```

## How To
- For or clone this repo
- Run ***mvn test***
