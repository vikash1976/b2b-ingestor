# b2b-ingestor
An attempt to build a sample CSV, TSV, XSL[X] file processor. Aim is to read the csv/tsv/xsl(x) file along with its provided schema as TSV. Process and segregate valid and invalid records.

Also aimed to have localized server logging using ***logback*** and ***cal10n***. ***Apache POI*** library is used to process XLSX.

Currently Unit test provides input file name along with its releated schema file name and application looks for those files at a given folder on your machine - folder path is configured in ***Constants class*** . You may like to tweak Unit test and application per your choice of test setup.

## When locale is GERMANY:
```
Running com.vikash.fp.application.ApplicationTest
10:08:14.387 [main] INFO com.vikash.fp.application.Application - Verarbeitungsschemadatei: officeSchema.txt und Eingabedatei: offices.csv
10:08:14.616 [main] INFO com.vikash.fp.application.Application - Verarbeitung gegen Schemaeintr?ge:
10:08:14.616 [main] INFO com.vikash.fp.application.Application - [Schema Entry [Field=Id, Type=Nvarchar, Restrictions=NotNull,PrimaryKey], Schema Entry [Field=Name, Type=Nvarchar, Restrictions=NotNull], Schema Entry [Field=Address, Type=Nvarchar, Restrictions=Nullable], Schema Entry [Field=PrimaryDoctor, Type=Nvarchar, Restrictions=Nullable,ForeignKey]]
10:08:14.625 [main] INFO com.vikash.fp.impl.CsvReader - Schema-Verst??e gefunden f?r:
10:08:14.625 [main] INFO com.vikash.fp.impl.CsvReader - [Office [id=O2, name=null, address=Mumbai, primarydoctor=D3]]
10:08:14.625 [main] INFO com.vikash.fp.application.Application - Aufzeichnungen gut f?r die weitere Verarbeitung:
10:08:14.625 [main] INFO com.vikash.fp.application.Application - Office [id=O1, name=Office 1, address=Pune, primarydoctor=D5]
10:08:14.625 [main] INFO com.vikash.fp.application.Application - Office [id=O3, name=Office 3, address=Delhi, primarydoctor=D4]
10:08:14.625 [main] INFO com.vikash.fp.application.Application - Office [id=O4, name=Office 4, address=null, primarydoctor=D5]
10:08:14.625 [main] INFO com.vikash.fp.application.Application - Office [id=O5, name=Office 5, address=Indore, primarydoctor=D1]
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
10:08:14.627 [main] INFO com.vikash.fp.application.Application - Verarbeitungsschemadatei: doctorSchema.txt und Eingabedatei: doctors.csv
10:08:14.628 [main] INFO com.vikash.fp.application.Application - Verarbeitung gegen Schemaeintr?ge:
10:08:14.628 [main] INFO com.vikash.fp.application.Application - [Schema Entry [Field=Id, Type=Nvarchar, Restrictions=NotNull,PrimaryKey], Schema Entry [Field=Name, Type=Nvarchar, Restrictions=NotNull]]
10:08:14.630 [main] INFO com.vikash.fp.impl.CsvReader - Schema-Verst??e gefunden f?r:
10:08:14.630 [main] INFO com.vikash.fp.impl.CsvReader - [Doctor [id=null, name=Doctor 4], Doctor [id=D8, name=null]]
10:08:14.630 [main] INFO com.vikash.fp.application.Application - Aufzeichnungen gut f?r die weitere Verarbeitung:
10:08:14.630 [main] INFO com.vikash.fp.application.Application - Doctor [id=D1, name=Doctor 1]
10:08:14.630 [main] INFO com.vikash.fp.application.Application - Doctor [id=D2, name=Doctor 2]
10:08:14.630 [main] INFO com.vikash.fp.application.Application - Doctor [id=D3, name=Doctor 3]
10:08:14.630 [main] INFO com.vikash.fp.application.Application - Doctor [id=D5, name=Doctor 5]
10:08:14.630 [main] INFO com.vikash.fp.application.Application - Doctor [id=D6, name=Doctor 6]
10:08:14.630 [main] INFO com.vikash.fp.application.Application - Doctor [id=D7, name=Doctor 7]
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
10:08:14.631 [main] INFO com.vikash.fp.application.Application - Verarbeitungsschemadatei: doctorToOfficeSchema.txt und Eingabedatei: doctorToOffice.xlsx
10:08:14.632 [main] INFO com.vikash.fp.application.Application - Verarbeitung gegen Schemaeintr?ge:
10:08:14.632 [main] INFO com.vikash.fp.application.Application - [Schema Entry [Field=DoctorId, Type=Nvarchar, Restrictions=NotNull,ForeignKey], Schema Entry [Field=OfficeId, Type=Nvarchar, Restrictions=NotNull,ForeignKey]]
10:08:14.632 [main] INFO com.vikash.fp.application.Application - Processing XLSX file
10:08:15.557 [main] INFO com.vikash.fp.impl.XLXSReader - Schema-Verst??e gefunden f?r:
10:08:15.558 [main] INFO com.vikash.fp.impl.XLXSReader - [DoctorToOffice [doctorid=null, officeid=O2], DoctorToOffice [doctorid=D2, officeid=null]]
10:08:15.558 [main] INFO com.vikash.fp.application.Application - Aufzeichnungen gut f?r die weitere Verarbeitung:
10:08:15.558 [main] INFO com.vikash.fp.application.Application - DoctorToOffice [doctorid=D1, officeid=O1]
10:08:15.558 [main] INFO com.vikash.fp.application.Application - DoctorToOffice [doctorid=D3, officeid=O2]
10:08:15.558 [main] INFO com.vikash.fp.application.Application - DoctorToOffice [doctorid=D4, officeid=O5]
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
Tests run: 3, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 1.321 sec

Results :

Tests run: 3, Failures: 0, Errors: 0, Skipped: 0

```

## When locale is FRENCH:
```
Running com.vikash.fp.application.ApplicationTest
10:08:57.090 [main] INFO com.vikash.fp.application.Application - Traitement du fichier de sch?ma: officeSchema.txt et du fichier dentr?e: {1}
10:08:57.308 [main] INFO com.vikash.fp.application.Application - Traitement par rapport aux entr?es de sch?ma: 
10:08:57.308 [main] INFO com.vikash.fp.application.Application - [Schema Entry [Field=Id, Type=Nvarchar, Restrictions=NotNull,PrimaryKey], Schema Entry [Field=Name, Type=Nvarchar, Restrictions=NotNull], Schema Entry [Field=Address, Type=Nvarchar, Restrictions=Nullable], Schema Entry [Field=PrimaryDoctor, Type=Nvarchar, Restrictions=Nullable,ForeignKey]]
10:08:57.316 [main] INFO com.vikash.fp.impl.CsvReader - Violations de sch?ma d?tect?es pour:
10:08:57.316 [main] INFO com.vikash.fp.impl.CsvReader - [Office [id=O2, name=null, address=Mumbai, primarydoctor=D3]]
10:08:57.316 [main] INFO com.vikash.fp.application.Application - Enregistrements bons pour un traitement ult?rieur:
10:08:57.316 [main] INFO com.vikash.fp.application.Application - Office [id=O1, name=Office 1, address=Pune, primarydoctor=D5]
10:08:57.316 [main] INFO com.vikash.fp.application.Application - Office [id=O3, name=Office 3, address=Delhi, primarydoctor=D4]
10:08:57.316 [main] INFO com.vikash.fp.application.Application - Office [id=O4, name=Office 4, address=null, primarydoctor=D5]
10:08:57.316 [main] INFO com.vikash.fp.application.Application - Office [id=O5, name=Office 5, address=Indore, primarydoctor=D1]
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
10:08:57.318 [main] INFO com.vikash.fp.application.Application - Traitement du fichier de sch?ma: doctorSchema.txt et du fichier dentr?e: {1}
10:08:57.319 [main] INFO com.vikash.fp.application.Application - Traitement par rapport aux entr?es de sch?ma: 
10:08:57.319 [main] INFO com.vikash.fp.application.Application - [Schema Entry [Field=Id, Type=Nvarchar, Restrictions=NotNull,PrimaryKey], Schema Entry [Field=Name, Type=Nvarchar, Restrictions=NotNull]]
10:08:57.322 [main] INFO com.vikash.fp.impl.CsvReader - Violations de sch?ma d?tect?es pour:
10:08:57.322 [main] INFO com.vikash.fp.impl.CsvReader - [Doctor [id=null, name=Doctor 4], Doctor [id=D8, name=null]]
10:08:57.322 [main] INFO com.vikash.fp.application.Application - Enregistrements bons pour un traitement ult?rieur:
10:08:57.322 [main] INFO com.vikash.fp.application.Application - Doctor [id=D1, name=Doctor 1]
10:08:57.322 [main] INFO com.vikash.fp.application.Application - Doctor [id=D2, name=Doctor 2]
10:08:57.322 [main] INFO com.vikash.fp.application.Application - Doctor [id=D3, name=Doctor 3]
10:08:57.322 [main] INFO com.vikash.fp.application.Application - Doctor [id=D5, name=Doctor 5]
10:08:57.322 [main] INFO com.vikash.fp.application.Application - Doctor [id=D6, name=Doctor 6]
10:08:57.322 [main] INFO com.vikash.fp.application.Application - Doctor [id=D7, name=Doctor 7]
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
10:08:57.323 [main] INFO com.vikash.fp.application.Application - Traitement du fichier de sch?ma: doctorToOfficeSchema.txt et du fichier dentr?e: {1}
10:08:57.324 [main] INFO com.vikash.fp.application.Application - Traitement par rapport aux entr?es de sch?ma: 
10:08:57.324 [main] INFO com.vikash.fp.application.Application - [Schema Entry [Field=DoctorId, Type=Nvarchar, Restrictions=NotNull,ForeignKey], Schema Entry [Field=OfficeId, Type=Nvarchar, Restrictions=NotNull,ForeignKey]]
10:08:57.324 [main] INFO com.vikash.fp.application.Application - Processing XLSX file
10:08:58.259 [main] INFO com.vikash.fp.impl.XLXSReader - Violations de sch?ma d?tect?es pour:
10:08:58.259 [main] INFO com.vikash.fp.impl.XLXSReader - [DoctorToOffice [doctorid=null, officeid=O2], DoctorToOffice [doctorid=D2, officeid=null]]
10:08:58.259 [main] INFO com.vikash.fp.application.Application - Enregistrements bons pour un traitement ult?rieur:
10:08:58.259 [main] INFO com.vikash.fp.application.Application - DoctorToOffice [doctorid=D1, officeid=O1]
10:08:58.259 [main] INFO com.vikash.fp.application.Application - DoctorToOffice [doctorid=D3, officeid=O2]
10:08:58.259 [main] INFO com.vikash.fp.application.Application - DoctorToOffice [doctorid=D4, officeid=O5]
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
Tests run: 3, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 1.355 sec

Results :

Tests run: 3, Failures: 0, Errors: 0, Skipped: 0
```

## When locale is ENGLISH
```
Running com.vikash.fp.application.ApplicationTest
10:04:46.947 [main] INFO com.vikash.fp.application.Application - Processing schema file: officeSchema.txt and input file: offices.csv
10:04:47.154 [main] INFO com.vikash.fp.application.Application - Processing against schema entries:
10:04:47.155 [main] INFO com.vikash.fp.application.Application - [Schema Entry [Field=Id, Type=Nvarchar, Restrictions=NotNull,PrimaryKey], Schema Entry [Field=Name, Type=Nvarchar, Restrictions=NotNull], Schema Entry [Field=Address, Type=Nvarchar, Restrictions=Nullable], Schema Entry [Field=PrimaryDoctor, Type=Nvarchar, Restrictions=Nullable,ForeignKey]]
10:04:47.163 [main] INFO com.vikash.fp.impl.CsvReader - Schema violations found for:
10:04:47.163 [main] INFO com.vikash.fp.impl.CsvReader - [Office [id=O2, name=null, address=Mumbai, primarydoctor=D3]]
10:04:47.163 [main] INFO com.vikash.fp.application.Application - Records good for further processing:
10:04:47.163 [main] INFO com.vikash.fp.application.Application - Office [id=O1, name=Office 1, address=Pune, primarydoctor=D5]
10:04:47.163 [main] INFO com.vikash.fp.application.Application - Office [id=O3, name=Office 3, address=Delhi, primarydoctor=D4]
10:04:47.163 [main] INFO com.vikash.fp.application.Application - Office [id=O4, name=Office 4, address=null, primarydoctor=D5]
10:04:47.163 [main] INFO com.vikash.fp.application.Application - Office [id=O5, name=Office 5, address=Indore, primarydoctor=D1]
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
10:04:47.164 [main] INFO com.vikash.fp.application.Application - Processing schema file: doctorSchema.txt and input file: doctors.csv
10:04:47.166 [main] INFO com.vikash.fp.application.Application - Processing against schema entries:
10:04:47.166 [main] INFO com.vikash.fp.application.Application - [Schema Entry [Field=Id, Type=Nvarchar, Restrictions=NotNull,PrimaryKey], Schema Entry [Field=Name, Type=Nvarchar, Restrictions=NotNull]]
10:04:47.167 [main] INFO com.vikash.fp.impl.CsvReader - Schema violations found for:
10:04:47.168 [main] INFO com.vikash.fp.impl.CsvReader - [Doctor [id=null, name=Doctor 4], Doctor [id=D8, name=null]]
10:04:47.168 [main] INFO com.vikash.fp.application.Application - Records good for further processing:
10:04:47.168 [main] INFO com.vikash.fp.application.Application - Doctor [id=D1, name=Doctor 1]
10:04:47.168 [main] INFO com.vikash.fp.application.Application - Doctor [id=D2, name=Doctor 2]
10:04:47.168 [main] INFO com.vikash.fp.application.Application - Doctor [id=D3, name=Doctor 3]
10:04:47.168 [main] INFO com.vikash.fp.application.Application - Doctor [id=D5, name=Doctor 5]
10:04:47.168 [main] INFO com.vikash.fp.application.Application - Doctor [id=D6, name=Doctor 6]
10:04:47.168 [main] INFO com.vikash.fp.application.Application - Doctor [id=D7, name=Doctor 7]
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
10:04:47.168 [main] INFO com.vikash.fp.application.Application - Processing schema file: doctorToOfficeSchema.txt and input file: doctorToOffice.xlsx
10:04:47.169 [main] INFO com.vikash.fp.application.Application - Processing against schema entries:
10:04:47.169 [main] INFO com.vikash.fp.application.Application - [Schema Entry [Field=DoctorId, Type=Nvarchar, Restrictions=NotNull,ForeignKey], Schema Entry [Field=OfficeId, Type=Nvarchar, Restrictions=NotNull,ForeignKey]]
10:04:47.170 [main] INFO com.vikash.fp.application.Application - Processing XLSX file
10:04:48.039 [main] INFO com.vikash.fp.impl.XLXSReader - Schema violations found for:
10:04:48.040 [main] INFO com.vikash.fp.impl.XLXSReader - [DoctorToOffice [doctorid=null, officeid=O2], DoctorToOffice [doctorid=D2, officeid=null]]
10:04:48.040 [main] INFO com.vikash.fp.application.Application - Records good for further processing:
10:04:48.040 [main] INFO com.vikash.fp.application.Application - DoctorToOffice [doctorid=D1, officeid=O1]
10:04:48.040 [main] INFO com.vikash.fp.application.Application - DoctorToOffice [doctorid=D3, officeid=O2]
10:04:48.040 [main] INFO com.vikash.fp.application.Application - DoctorToOffice [doctorid=D4, officeid=O5]
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
Tests run: 3, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 1.236 sec

Results :

Tests run: 3, Failures: 0, Errors: 0, Skipped: 0
```

## How To
- For or clone this repo
- Run ***mvn test***
