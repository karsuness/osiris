# coding=utf-8
import time
import datetime


def run(times):
    last_repay_date_str = '2018-10-10'
    d = datetime.datetime.strptime(last_repay_date_str, "%Y-%m-%d")
    print(d)
    # 转成时间戳
    timestamp = int(time.mktime(d.timetuple()))
    unix_timestamp = timestamp * 1000

    print("times%s" % times)
    print("times%s" % unix_timestamp)


run(1539100800000)
