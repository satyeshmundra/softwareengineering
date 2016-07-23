#include "Date.h"
#include <bits/stdc++.h>


DateFormat Date::format = DateFormat();

Date::Date(Day d, Month m, Year y) throw(invalid_argument, domain_error, out_of_range)
{
	//constructor for date d, m, y

	int day = static_cast<int>(d);
	int month = static_cast<int>(m);

	if(month<1 || month>12)
	{
		throw invalid_argument("not a valid month");

	}

	if(day<1 || day>31)
	{
		throw invalid_argument("not a valid date");
	}
	else
	{
		if(month==4 || month==6 || m==9 || m==11)
		{
			if(day > 30)
				throw domain_error("only 30 days in the month");
		}
		else
			if(m ==2 )
			{
				if(y%4 == 0)
				{
					if(day > 29)
						throw domain_error("only 29 days in the month");
				}
				else
				{
					if(day > 28)
						throw domain_error("only 28 days in the month");
				}
			}

	}

	if(y <1950 || y > 2049)
		throw out_of_range("year not within the given range");

	this->d = d;
	this->m = m;
	this->y = y;
}

Date::Date(Date const& date)
{
		//constructor for copy
	this->d = date.d;
	this->m = date.m;
	this->y = date.y;
}

Date::Date() throw(domain_error, out_of_range)
{
		//constructor for date default
	time_t t = time(0);
	struct tm* curr_time = localtime(&t);

	this->d = static_cast<Day>(curr_time-> tm_mday);
	this->m = static_cast<Month>(curr_time->tm_mon + 1);
	this->y = static_cast<Year>(curr_time->tm_year + 1900);

	if(y <1950 || y > 2049)
		throw out_of_range("year not within the given range");
}

Date::Date(const char* date) throw(invalid_argument, domain_error, out_of_range)
{

	//constructor for date "d-m-y"
	if(format.getdateFormat() == NULL || format.getmonthFormat() == NULL || format.getyearFormat() == NULL)
	{
		throw invalid_argument("set format first \n");
	}

	char *d_, *m_, *y_;

	char *temp = new char();
	strcpy(temp , date);

	int i = 0, count = 0;
	while(temp[i] != '\0' )
	{

		if( temp[i] == '-')//no of "-"
			count++;
		i++;
	}

	if(count != 2)
	{
		//cout<<"Wrong format! \n";
		throw invalid_argument("wrong date format");
		Date();

	}

	d_ = strtok(temp, "-");
	m_ = strtok(NULL, "-");
	y_ = strtok(NULL, "-");

	int dd = atoi(d_);
	int mm = atoi(m_);
	int yy = atoi(y_);


	if(dd < 10)
	{
		if(!(strlen(d_) == strlen(format.getdateFormat())))//for format d or dd
		{
			throw invalid_argument("Mismatching date format! ");
		}
	}

	if(mm < 10)
	{
		if(strlen(m_) != strlen(format.getmonthFormat()))//for format , or mm
		{
			throw invalid_argument("Mismatching month format! ");
		}
	}

	if(strcmp(format.getyearFormat(), "yy") == 0)
	{
		if(yy >= 50 && yy<100)
			yy+=1900;
		else
			if(yy >=0 && yy< 100)
				yy+= 2000;

		else throw invalid_argument("Mismatching year format! ");
	}

	else
	{
		if(yy>=0 && yy<100)
			throw invalid_argument("Mismatching year format! ");
	}
	Day day = (Day)(dd);
	Month month = (Month)(mm);
	Year year = (Year)(yy);

	Date new_date(day, month, year);

	*this = new_date;
}

Date& Date::operator=(const Date& date)
{
	if(*this != date)
	{
		this->d = date.d;
		this->m = date.m;
		this->y = date.y;
	}
	return *this;
}

int Date::dayno() const //converts date to day no.
{
	int d1, m1, y1;
	d1 = static_cast<int>(this->d);
	m1 = static_cast<int>(this->m);
	y1 = static_cast<int>(this->y);

	m1 = (m1 + 9) % 12 ;
	y1 = y1 - m1/10 ;
	if(y<2000 || y%4 == 0)
	return (365*y1 + y1/4 - y1/100 + y1/400 + (m1*306 + 5)/10 + ( d1 - 1 ) );//4578
	else
	return (365*y1 + y1/4 - y1/100 + y1/400 + (m1*306 + 5)/10 + ( d1 - 1 ) );
		
}
// Date Date::dateno(int n)
// {
// 	long long int y, ddd, mm, mi, dd ;
// 	y = (10000*n + 14780)/3652425;
// 	ddd = n - (365*y + y/4 - y/100 + y/400);
// 	if (ddd < 0)
// 	{
// 		 y = y - 1;
// 		 ddd = n - (365*y + y/4 - y/100 + y/400);
// 	}
// 	mi = (100*ddd + 52)/3060;
// 	mm = (mi + 2)%12 + 1;
// 	y = y + (mi + 2)/12;
// 	dd = ddd - (mi*306 + 5)/10 + 1;

// 	Date date = Date(static_cast<Day>(dd), static_cast<Month>(mm), static_cast<Year>(y));

// 	return date;
// }

Date Date::operator+ (int n) throw( out_of_range)
{
	tm t = {};
    t.tm_year = static_cast<unsigned int>(y)-1900;
    t.tm_mon  = static_cast<unsigned int>(m)-1;
    t.tm_mday = static_cast<unsigned int>(d);
    
    t.tm_mday += n;
    mktime(&t);
    
    Date date;
    date.y  = static_cast<Year> (1900+ t.tm_year);
    date.m = static_cast<Month>(t.tm_mon +1);
    date.d   = static_cast<Day>  (t.tm_mday);
    
    if(date.y <1950 || date.y > 2049)
 		throw out_of_range("year not within the given range");
 	return date;
}

Date& Date::operator++()
{
	*this = *this + 1;
	return *this; 
}

Date& Date::operator++(int n)
{
	*this = *this + 7;
	return *this; 
}

Date& Date::operator--()
{
	*this = *this + (-1);
	return *this; 
 
}

Date& Date::operator--(int n)
{
	*this = *this + (-7);
	return *this; 
}



bool Date::leapYear() const
{
	if(y % 4 == 0)
		return 1;
	else 
		return 0;
}

bool Date::operator==(const Date& otherDate)
{
	if(this->dayno() == otherDate.dayno())
		return 1;
	else
		return 0;
}

bool Date::operator!=(const Date& otherDate)
{
	if(this->dayno() != otherDate.dayno())
		return 1;
	else
		return 0;
}

bool Date::operator<(const Date& otherDate)
{
	if(this->dayno() < otherDate.dayno())
		return 1;
	else
		return 0;
}

bool Date::operator<=(const Date& otherDate)
{
	if(this->dayno() <= otherDate.dayno())
		return 1;
	else
		return 0;
}

bool Date::operator>(const Date& otherDate)
{
	if(this->dayno() > otherDate.dayno())
		return 1;
	else
		return 0;
}

bool Date::operator>=(const Date& otherDate)
{
	if(this->dayno() >= otherDate.dayno())
		return 1;
	else
		return 0;
}

unsigned int Date::operator-(const Date& otherDate)
{
	return (abs(this->dayno() - otherDate.dayno()) );
}


Date::operator WeekNumber() const
{
  const Date yearstart(D01, Jan, this->y);
  int weekno = 0;
  Date firstmon = yearstart;
  Date firstthurs = yearstart;
  Date temp = (*this);
  int diff = temp-yearstart;
  int key=0;
  WeekDay a =  (WeekDay)(*this);
  WeekDay b =  (WeekDay)yearstart;
  WeekDay c =  (WeekDay)firstmon;
  WeekDay e =  (WeekDay)firstthurs;
  WeekDay tempa =  (WeekDay)temp;
  while(c!=1){
    ++firstmon;
    c =  (WeekDay)firstmon;
  }
  while(e!=4){
    ++firstthurs;
    e =  (WeekDay)firstthurs;
  }
  if(this->m==12 && a<4){
    while(tempa!=4){
      ++temp;
      tempa =  (WeekDay)temp;
    }
    if(temp.y!=this->y){
      weekno=1;
      return static_cast<WeekNumber>(weekno);
    }
  }
  if(firstmon<firstthurs){
    key=firstmon.d-1;
    diff-=key;
    if(diff>=0){
      diff = diff/7;
      weekno = diff+1;
      return static_cast<WeekNumber>(weekno);
    }
    else{
      for(int i =0;i<4;++i){
        --temp;
      }
      WeekNumber wno = (WeekNumber)temp;
      return wno;
    }
  }
  if(firstmon>firstthurs){
    key=firstmon.d-1;
    diff-=key;
    if(diff>=0){
      diff = diff/7;
      weekno = diff+2;
      return static_cast<WeekNumber>(weekno);
    }
    else{
      weekno=1;
      return static_cast<WeekNumber>(weekno);
    }
  }
}

ostream& operator<<(ostream& os, const Date& date)
{
	int dd = static_cast<int>(date.d);
	int mm = static_cast<int>(date.m);
	int yy = static_cast<int>(date.y);

	if(Date::format.getdateFormat() == 0 || strcmp(Date::format.getdateFormat(), "" ) == 0)
	{
		os<<"";
	}
	else if(strcmp(Date::format.getdateFormat() , "dd") ==  0)
	{
		if(dd > 9)
			os<<dd;
		else
		{
			os<<"0"<<dd;
		}
	}
	else
	{
		os<<dd;
	}
	os<<"-";

	if(Date::format.getmonthFormat() == 0 || strcmp(Date::format.getmonthFormat(), "" ) == 0)
	{
		switch(mm)
		{
			case 1:os<<"January"; break;
			case 2:os<<"February"; break;
			case 3:os<<"March"; break;
			case 4:os<<"April"; break;
			case 5:os<<"May"; break;
			case 6:	os<<"June";	break;
			case 7:	os<<"July";	break;
			case 8:	os<<"August"; break;
			case 9:	os<<"September"; break;
			case 10: os<<"October"; break;
			case 11: os<<"November"; break;
			case 12: os<<"December"; break;
			default: os<<"Invalid";
		}
	}
	else if(strcmp(Date::format.getmonthFormat(), "mmm") == 0)
	{
		switch(mm)
		{
			case 1:	os<<"Jan";	break;
			case 2:	os<<"Feb";	break;
			case 3:	os<<"Mar";	break;
			case 4:	os<<"Apr";	break;
			case 5:	os<<"May";	break;
			case 6:	os<<"Jun";	break;
			case 7:	os<<"Jul";	break;
			case 8:	os<<"Aug";	break;
			case 9:	os<<"Sep";	break;
			case 10: os<<"Oct"; break;
			case 11: os<<"Nov";	break;
			case 12: os<<"Dec";	break;
			default: os<<"Invalid";
		}

	}
	else if(strcmp(Date::format.getmonthFormat() , "mm") ==  0)
	{
		if(mm > 9)
			os<<mm;
		else
		{
			os<<"0"<<mm;
		}
	}
	else
	{
		os<<mm;
	}
	os<<"-";


	if(Date::format.getyearFormat() == 0 || strcmp(Date::format.getyearFormat(), "" ) == 0)
	{
		os<<"";
	}
	else if(strcmp(Date::format.getyearFormat() , "yy") == 0)
	{
		if((yy % 100) < 10)
			os<<"0";
		os<<(yy%100);
	}
	else
	{
		os<<yy;
	}
}

istream& operator>>(istream& is, Date& date)
{
	char s[15];
	is>>s;
	try
	{
		Date d(s);
		date = d;
	}
	catch(...)
	{
		cout<<"Invalid Date. Initializing to current date.";
		Date d = Date();
		date = d;
		return is;
	}
	return is;
}

Date::operator WeekDay() const
{
	const Date sun = Date(D01, Jan, 1950);
	int dd = (this->dayno() - sun.dayno());
	if(dd%7 == 0)
		dd = 7;
	else
		dd = dd % 7;
	return (WeekDay)(dd);
}

Date::operator Month() const
{
	return (this -> m);
}

void Date::setFormat(DateFormat& f)
{

	format = f;
}

DateFormat& Date::getFormat()
{
	return format;
} 

/**/