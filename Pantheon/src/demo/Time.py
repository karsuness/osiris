# coding=utf-8
import time
import datetime


def calc_time1(unix_time):
    tt = time.localtime(unix_time)
    date1 = time.strftime("%Y-%m-%d", tt)
    date2 = time.strftime("%Y-%m-%d", tt)

    date1 = datetime.datetime(date1[0], date1[1], date1[2])
    date2 = datetime.datetime(date2[0], date2[1], date2[2])

    print("时间相差%s", date2 - date1)


def calc_time2(unix_time1, unix_time2):
    time_str = unix_time2 - unix_time1
    print("时间相差%s", time_str)


def calc_time3(unix_time):
    # start_str = time.strftime("%Y-%m-%d", time.localtime(unix_time/1000))
    end_str = time.strftime('%Y-%m-%d', time.localtime())
    start = datetime.datetime.strptime(unix_time, '%Y-%m-%d 00:00:00')
    end = datetime.datetime.strptime(end_str, '%Y-%m-%d')
    print (start)
    print (end)
    ddd = end - start
    print (ddd.days)


calc_time3('2018-12-12 00:00:00')
# calc_time3(1545696000000, 1545868800000)
