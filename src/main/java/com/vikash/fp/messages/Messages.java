package com.vikash.fp.messages;

import ch.qos.cal10n.BaseName;
import ch.qos.cal10n.Locale;
import ch.qos.cal10n.LocaleData;

@BaseName("messages")
@LocaleData(
  defaultCharset="UTF8",
  value = { @Locale("en_UK"),
            @Locale("fr_FR"),
            @Locale("de_DE")
           }
   )
public enum Messages {
	FILE_PROCESSING,
	SUCCESSFULL_RECORDS,
	FAILED_RECORDS,
	SCHEMA_ENTRIES
}
