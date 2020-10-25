# b2b-ingestor
An attempt to build a sample CSV, TSV, XSL[X] (to be attempted) file processor. Aim is to read the csv/tsv/xsl(x) file along with its provided schema as TSV. Process and segregate valid and invalid records.

## Also aimed to have localized server logging using logback and cal10n.

Currently Unit test provides input file name along with its releated schema file name and application looks for those files at a given folder on your machine - folder path is configured in ***Constants class*** . You may like to tweak Unit test and application per your choice of test setup.

## When locale is GERMANY:
```
Running com.vikash.fp.application.ApplicationTest
09:46:35.316 [main] INFO com.vikash.fp.application.Application - Verarbeitungsschemadatei: officeSchema.csv und Eingabedatei: offices.csv
09:46:35.522 [main] INFO com.vikash.fp.application.Application - Verarbeitung gegen Schemaeintr?ge:
09:46:35.522 [main] INFO com.vikash.fp.application.Application - [Schema Entry [Field=Id, Type=Nvarchar, Restrictions=NotNull,PrimaryKey], Schema Entry [Field=Name, Type=Nvarchar, Restrictions=NotNull], Schema Entry [Field=Address, Type=Nvarchar, Restrictions=Nullable], Schema Entry [Field=PrimaryDoctor, Type=Nvarchar, Restrictions=Nullable,ForeignKey]]
09:46:35.532 [main] INFO com.vikash.fp.interfaces.AbstractFileReader - Schema-Verst??e gefunden f?r:
09:46:35.532 [main] INFO com.vikash.fp.interfaces.AbstractFileReader - [Office [id=O2, name=null, address=Mumbai, primarydoctor=D3]]
09:46:35.532 [main] INFO com.vikash.fp.application.Application - Aufzeichnungen gut f?r die weitere Verarbeitung:
09:46:35.532 [main] INFO com.vikash.fp.application.Application - Office [id=O1, name=Office 1, address=Pune, primarydoctor=D5]
09:46:35.532 [main] INFO com.vikash.fp.application.Application - Office [id=O3, name=Office 3, address=Delhi, primarydoctor=D4]
09:46:35.532 [main] INFO com.vikash.fp.application.Application - Office [id=O4, name=Office 4, address=null, primarydoctor=D5]
09:46:35.532 [main] INFO com.vikash.fp.application.Application - Office [id=O5, name=Office 5, address=Indore, primarydoctor=D1]
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
09:46:35.534 [main] INFO com.vikash.fp.application.Application - Verarbeitungsschemadatei: doctorSchema.csv und Eingabedatei: doctors.csv
09:46:35.535 [main] INFO com.vikash.fp.application.Application - Verarbeitung gegen Schemaeintr?ge:
09:46:35.535 [main] INFO com.vikash.fp.application.Application - [Schema Entry [Field=Id, Type=Nvarchar, Restrictions=NotNull,PrimaryKey], Schema Entry [Field=Name, Type=Nvarchar, Restrictions=NotNull]]
09:46:35.537 [main] INFO com.vikash.fp.interfaces.AbstractFileReader - Schema-Verst??e gefunden f?r:
09:46:35.537 [main] INFO com.vikash.fp.interfaces.AbstractFileReader - [Doctor [id=null, name=Doctor 4], Doctor [id=D8, name=null]]
09:46:35.538 [main] INFO com.vikash.fp.application.Application - Aufzeichnungen gut f?r die weitere Verarbeitung:
09:46:35.538 [main] INFO com.vikash.fp.application.Application - Doctor [id=D1, name=Doctor 1]
09:46:35.538 [main] INFO com.vikash.fp.application.Application - Doctor [id=D2, name=Doctor 2]
09:46:35.538 [main] INFO com.vikash.fp.application.Application - Doctor [id=D3, name=Doctor 3]
09:46:35.538 [main] INFO com.vikash.fp.application.Application - Doctor [id=D5, name=Doctor 5]
09:46:35.538 [main] INFO com.vikash.fp.application.Application - Doctor [id=D6, name=Doctor 6]
09:46:35.538 [main] INFO com.vikash.fp.application.Application - Doctor [id=D7, name=Doctor 7]
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
Tests run: 2, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.373 sec

Results :

Tests run: 2, Failures: 0, Errors: 0, Skipped: 0

```

## When locale is FRENCH:
```
Running com.vikash.fp.application.ApplicationTest
09:47:22.509 [main] INFO com.vikash.fp.application.Application - Traitement du fichier de sch?ma: officeSchema.csv et du fichier dentr?e: {1}
09:47:22.735 [main] INFO com.vikash.fp.application.Application - Traitement par rapport aux entr?es de sch?ma: 
09:47:22.735 [main] INFO com.vikash.fp.application.Application - [Schema Entry [Field=Id, Type=Nvarchar, Restrictions=NotNull,PrimaryKey], Schema Entry [Field=Name, Type=Nvarchar, Restrictions=NotNull], Schema Entry [Field=Address, Type=Nvarchar, Restrictions=Nullable], Schema Entry [Field=PrimaryDoctor, Type=Nvarchar, Restrictions=Nullable,ForeignKey]]
09:47:22.745 [main] INFO com.vikash.fp.interfaces.AbstractFileReader - Violations de sch?ma d?tect?es pour:
09:47:22.745 [main] INFO com.vikash.fp.interfaces.AbstractFileReader - [Office [id=O2, name=null, address=Mumbai, primarydoctor=D3]]
09:47:22.745 [main] INFO com.vikash.fp.application.Application - Enregistrements bons pour un traitement ult?rieur:
09:47:22.745 [main] INFO com.vikash.fp.application.Application - Office [id=O1, name=Office 1, address=Pune, primarydoctor=D5]
09:47:22.745 [main] INFO com.vikash.fp.application.Application - Office [id=O3, name=Office 3, address=Delhi, primarydoctor=D4]
09:47:22.745 [main] INFO com.vikash.fp.application.Application - Office [id=O4, name=Office 4, address=null, primarydoctor=D5]
09:47:22.745 [main] INFO com.vikash.fp.application.Application - Office [id=O5, name=Office 5, address=Indore, primarydoctor=D1]
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
09:47:22.746 [main] INFO com.vikash.fp.application.Application - Traitement du fichier de sch?ma: doctorSchema.csv et du fichier dentr?e: {1}
09:47:22.748 [main] INFO com.vikash.fp.application.Application - Traitement par rapport aux entr?es de sch?ma: 
09:47:22.748 [main] INFO com.vikash.fp.application.Application - [Schema Entry [Field=Id, Type=Nvarchar, Restrictions=NotNull,PrimaryKey], Schema Entry [Field=Name, Type=Nvarchar, Restrictions=NotNull]]
09:47:22.750 [main] INFO com.vikash.fp.interfaces.AbstractFileReader - Violations de sch?ma d?tect?es pour:
09:47:22.750 [main] INFO com.vikash.fp.interfaces.AbstractFileReader - [Doctor [id=null, name=Doctor 4], Doctor [id=D8, name=null]]
09:47:22.751 [main] INFO com.vikash.fp.application.Application - Enregistrements bons pour un traitement ult?rieur:
09:47:22.751 [main] INFO com.vikash.fp.application.Application - Doctor [id=D1, name=Doctor 1]
09:47:22.751 [main] INFO com.vikash.fp.application.Application - Doctor [id=D2, name=Doctor 2]
09:47:22.751 [main] INFO com.vikash.fp.application.Application - Doctor [id=D3, name=Doctor 3]
09:47:22.751 [main] INFO com.vikash.fp.application.Application - Doctor [id=D5, name=Doctor 5]
09:47:22.751 [main] INFO com.vikash.fp.application.Application - Doctor [id=D6, name=Doctor 6]
09:47:22.751 [main] INFO com.vikash.fp.application.Application - Doctor [id=D7, name=Doctor 7]
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
Tests run: 2, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.391 sec

Results :

Tests run: 2, Failures: 0, Errors: 0, Skipped: 0
```

## When locale is ENGLISH
```
Running com.vikash.fp.application.ApplicationTest
09:44:38.376 [main] INFO com.vikash.fp.application.Application - Processing schema file: officeSchema.csv and input file: offices.csv
09:44:38.593 [main] INFO com.vikash.fp.application.Application - Processing against schema entries:
09:44:38.593 [main] INFO com.vikash.fp.application.Application - [Schema Entry [Field=Id, Type=Nvarchar, Restrictions=NotNull,PrimaryKey], Schema Entry [Field=Name, Type=Nvarchar, Restrictions=NotNull], Schema Entry [Field=Address, Type=Nvarchar, Restrictions=Nullable], Schema Entry [Field=PrimaryDoctor, Type=Nvarchar, Restrictions=Nullable,ForeignKey]]
09:44:38.601 [main] INFO com.vikash.fp.interfaces.AbstractFileReader - Schema violations found for:
09:44:38.601 [main] INFO com.vikash.fp.interfaces.AbstractFileReader - [Office [id=O2, name=null, address=Mumbai, primarydoctor=D3]]
09:44:38.601 [main] INFO com.vikash.fp.application.Application - Records good for further processing:
09:44:38.601 [main] INFO com.vikash.fp.application.Application - Office [id=O1, name=Office 1, address=Pune, primarydoctor=D5]
09:44:38.601 [main] INFO com.vikash.fp.application.Application - Office [id=O3, name=Office 3, address=Delhi, primarydoctor=D4]
09:44:38.601 [main] INFO com.vikash.fp.application.Application - Office [id=O4, name=Office 4, address=null, primarydoctor=D5]
09:44:38.601 [main] INFO com.vikash.fp.application.Application - Office [id=O5, name=Office 5, address=Indore, primarydoctor=D1]
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
09:44:38.603 [main] INFO com.vikash.fp.application.Application - Processing schema file: doctorSchema.csv and input file: doctors.csv
09:44:38.604 [main] INFO com.vikash.fp.application.Application - Processing against schema entries:
09:44:38.605 [main] INFO com.vikash.fp.application.Application - [Schema Entry [Field=Id, Type=Nvarchar, Restrictions=NotNull,PrimaryKey], Schema Entry [Field=Name, Type=Nvarchar, Restrictions=NotNull]]
09:44:38.607 [main] INFO com.vikash.fp.interfaces.AbstractFileReader - Schema violations found for:
09:44:38.607 [main] INFO com.vikash.fp.interfaces.AbstractFileReader - [Doctor [id=null, name=Doctor 4], Doctor [id=D8, name=null]]
09:44:38.607 [main] INFO com.vikash.fp.application.Application - Records good for further processing:
09:44:38.607 [main] INFO com.vikash.fp.application.Application - Doctor [id=D1, name=Doctor 1]
09:44:38.607 [main] INFO com.vikash.fp.application.Application - Doctor [id=D2, name=Doctor 2]
09:44:38.607 [main] INFO com.vikash.fp.application.Application - Doctor [id=D3, name=Doctor 3]
09:44:38.607 [main] INFO com.vikash.fp.application.Application - Doctor [id=D5, name=Doctor 5]
09:44:38.607 [main] INFO com.vikash.fp.application.Application - Doctor [id=D6, name=Doctor 6]
09:44:38.607 [main] INFO com.vikash.fp.application.Application - Doctor [id=D7, name=Doctor 7]
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
Tests run: 2, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.389 sec

Results :

Tests run: 2, Failures: 0, Errors: 0, Skipped: 0
```

## How To
- For or clone this repo
- Run ***mvn test***
