#!/usr/bin/env python
# -*- coding: utf-8 -*-
import requests,json,time,os

if __name__ == "__main__":
  max_count = 10
  current = 0
  nacos_addr = os.getenv('NACOS_ADDR')
  sr = {}
  while(current <= max_count):
    try:
      sr = requests.get("http://" + nacos_addr + "/nacos/v1/ns/operator/servers")
    except:
      current = current + 1
      time.sleep(5)
      continue
    if(sr.status_code != 200):
      current = current + 1
      time.sleep(5)
      continue
    else:
      json_data = sr.json()
      if(len(json_data) == 0):
        current = current + 1
        time.sleep(5)
        continue
      else:
        print "get nacos servers :{}".format(json.dumps(json_data))
        break
  else:
    raise Exception,"达到最大限制10次,获取nacos信息失败"


