#include "DateFormat.h"
#include <bits/stdc++.h>
 

DateFormat::DateFormat(const char* dateFormat, const char* monthFormat, const char* yearFormat)
{
	this->dateFormat = const_cast<char *>(dateFormat);
	this->monthFormat = const_cast<char *>(monthFormat);
	this->yearFormat = const_cast<char *>(yearFormat);

	if(!(dateFormat == 0 || strcmp(dateFormat, "") == 0 || strcmp(dateFormat, "dd") == 0 || strcmp(dateFormat, "d") == 0))
	{
		cout<<"Wrong date format! ";
		dateFormat = NULL;
		//throw invalid_argument();
	}

	if(!(monthFormat == 0 || strcmp(monthFormat, "") == 0 || strcmp(monthFormat, "m") == 0 || strcmp(monthFormat, "mm") == 0 || strcmp(monthFormat, "mmm") == 0))
	{
		cout<<"Wrong month format! ";
		monthFormat = NULL;
		//throw invalid_argument();
	}

	if(!(yearFormat == 0 || strcmp(yearFormat, "") == 0  || strcmp(yearFormat, "yy") == 0 || strcmp(yearFormat, "yyyy") == 0))
	{
		cout<<"Wrong year format! ";
		yearFormat = NULL;
		//throw invalid_argument();
	}


}

DateFormat::DateFormat(const char* format)
{


	this->dateFormat = new char[12];
	this->monthFormat = new char[12];
	this->yearFormat = new char[12];


	string f = string(format);
	int i = 0, k=i, count = 0 ;
	
	while(format[i] != '\0' )
	{

		if( format[i] == '-')
			count++;
		i++;
	}

	if(count != 2)
	{
		cout<<"Wrong format! ";
		dateFormat = NULL;
		monthFormat = NULL;
		yearFormat = NULL;
	}
	else
	{
		i = 0;
		while(format[i] != '\0' && format[i] != '-')
		{
			i++;
		}
		strcpy(dateFormat, const_cast<char *>(f.substr(k, i-k).c_str()));

		i++;
		k=i;

		while(format[i] != '\0' && format[i] != '-')
		{
			i++;
		}

		strcpy(monthFormat , const_cast<char *>(f.substr(k, i-k).c_str()));
		i++;
		k=i;
		while(format[i] != '\0' )
		{
			i++;
		}
		strcpy(yearFormat, const_cast<char *>(f.substr(k, i-k).c_str()));

		if(!(strcmp(dateFormat, "") == 0|| strcmp(dateFormat, "dd") == 0 || strcmp(dateFormat, "d") == 0))
		{
			cout<<"Wrong date format! ";
			dateFormat = NULL;
		}

		if(!(strcmp(monthFormat, "") == 0 || strcmp(monthFormat, "m") == 0 || strcmp(monthFormat, "mm") == 0 || strcmp(monthFormat, "mmm") == 0))
		{
			cout<<"Wrong month format!";
			monthFormat = NULL;
		}

		if(!(strcmp(yearFormat, "") == 0 || yearFormat == 0 || strcmp(yearFormat, "yy") == 0 || strcmp(yearFormat, "yyyy") == 0))
		{
			cout<<"Wrong year format! ";
			yearFormat = NULL;
		}
	}
}

DateFormat::DateFormat()
{

	this->dateFormat = new char[12];
	this->monthFormat = new char[12];
	this->yearFormat = new char[12];
	strcpy(dateFormat, "dd");
	strcpy(monthFormat, "mmm");
	strcpy(yearFormat, "yy");
}

char* DateFormat::getdateFormat()
		{
			return dateFormat;
		}

char* DateFormat::getmonthFormat()
		{
			return monthFormat;
		}

char* DateFormat::getyearFormat()
		{
			return yearFormat;
		}

