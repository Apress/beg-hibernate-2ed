
* *DSV_TARGET_TABLE = geonames

/* Use tab as the delimiter */
* *DSV_COL_DELIM = \t



/* Give a report if something breaks */
* *DSV_REJECT_FILE = geonames-reject.dsv
* *DSV_REJECT_REPORT = geonames-reject.html
\x geonames

SELECT count(*) FROM geonames;

\p
\p See import reject report at '*{*DSV_REJECT_REPORT}'.
