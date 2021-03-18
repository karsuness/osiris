import datetime


def run(time_str):
    times = datetime.datetime.strptime(time_str, '%Y-%m-%d %H:%M:%S')
    print("times is %s" % times)


run('2018-10-01 12:12:12')
