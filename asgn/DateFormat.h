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


/*typedef

typedef enum WeekDay {
			Mon = 1, Tue = 2, Wed = 3, Thr = 4, Fri = 5, Sat = 6, Sun = 7 };


// A week starts on Monday and ends on Sunday. Weeks are numbered in a year from 1 to 52
// (or 53). Week 1 (W01) of a year starts contains the first Thursday of the year. Hence
// W01 of 2016 starts on 04/Jan and ends on 10/Jan as 07/Jan is the first Thursday.
// 01/Jan, 02/Jan, and 03/Jan therefore belongs to the last week of 2015.


typedef enum WeekNumber {
			W01 = 1, W02 = 2, W03 = 3, W04 = 4, W05 = 5,
			W06 = 6, W07 = 7, W08 = 8, W09 = 9, W10 = 10,
			W11 = 11, W12 = 12, W13 = 13, W14 = 14, W15 = 15,
			W16 = 16, W17 = 17, W18 = 18, W19 = 19, W20 = 20,
			W21 = 21, W22 = 22, W23 = 23, W24 = 24, W25 = 25,
			W26 = 26, W27 = 27, W28 = 28, W29 = 29, W30 = 30,
			W31 = 31, W32 = 32, W33 = 33, W34 = 34, W35 = 35,
			W36 = 36, W37 = 37, W38 = 38, W39 = 39, W40 = 40,
			W41 = 41, W42 = 42, W43 = 43, W44 = 44, W45 = 45,
			W46 = 46, W47 = 47, W48 = 48, W49 = 49, W50 = 50,
			W51 = 51, W52 = 52, W53 = 53 };



typedef enum Month {
			Jan = 1, Feb = 2, Mar =
			Jul = 7, Aug = 8, Sep =
			3, Apr = 4, May = 5, Jun = 6,
			9, Oct = 10, Nov = 11, Dec = 12 };


typedef unsigned int Year;

*/
