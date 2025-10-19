import sys

jaehwan_max = sys.stdin.readline().strip()
doctor_req = sys.stdin.readline().strip()

if len(jaehwan_max) >= len(doctor_req):
    print("go")
else:
    print("no")