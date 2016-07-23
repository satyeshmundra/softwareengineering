#include <iostream>
#include <exception>
#include "string.h"
#include <bits/stdc++.h>
using namespace std;

class DateFormat
{
	private:
		char* dateFormat;
		char* monthFormat;
		char* yearFormat;


	public:
		DateFormat(const char* dateFormat, const char* monthFormat, const char* yearFormat);

		// Single C-string format where dateFormat, monthFormat, and yearFormat are separated by ’-’
		// Example: "dd-mmm-yy", "d-mm-yyyy", etc
		DateFormat(const char* format);	


		// Default DateFormat created as "dd-mmm-yy"
		DateFormat();


		//~DateFormat();

		char* getdateFormat();

		char* getmonthFormat();

		char* getyearFormat();

};


