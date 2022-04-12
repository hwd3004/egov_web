사용한 dm는 오라클 11g

에러 내용 - unable to extend index "SYS.I_OBJ1" by 8 in tablespace SYSTEM

테이블 스페이스의 용량이 부족하다는 것 같다

https://coding-factory.tistory.com/411 - 오라클 DB의 테이블 스페이스란 무엇인가

https://javafactory.tistory.com/entry/오라클-테이블스페이스-용량-조회-oracle-tablespace-용량-조회

https://happytomorrow.net/126 - 오라클 테이블 스페이스 용량 늘리기

현재 dbf 파일들 위치 - C:\oraclexe\app\oracle\oradata\XE

```sql
select   substr(a.tablespace_name,1,30) tablespace,
         round(sum(a.total1)/1024/1024,1) "TotalMB",
         round(sum(a.total1)/1024/1024,1)-round(sum(a.sum1)/1024/1024,1) "UsedMB",
         round(sum(a.sum1)/1024/1024,1) "FreeMB",
         round((round(sum(a.total1)/1024/1024,1)-round(sum(a.sum1)/1024/1024,1))/round(sum(a.total1)/1024/1024,1)*100,2) "Used%"
from
         (select   tablespace_name,0 total1,sum(bytes) sum1,max(bytes) MAXB,count(bytes) cnt
          from     dba_free_space
          group by tablespace_name
          union
          select   tablespace_name,sum(bytes) total1,0,0,0
          from     dba_data_files
          group by tablespace_name) a
group by a.tablespace_name
order by tablespace;

SELECT TABLESPACE_NAME, FILE_NAME, BYTES/1024 AS MBytes, RESULT/1024 AS USE_MBytes FROM
  (
  SELECT E.TABLESPACE_NAME,E.FILE_NAME,E.BYTES, (E.BYTES-SUM(F.BYTES)) RESULT
  FROM DBA_DATA_FILES E, DBA_FREE_SPACE F
  WHERE E.FILE_ID = F.FILE_ID
  GROUP BY E.TABLESPACE_NAME, E.FILE_NAME, E.BYTES
  ) A;
```

```sql
alter database datafile 'C:\oraclexe\app\oracle\oradata\XE\SYSTEM.DBF' resize 2000m;

ALTER DATABASE DATAFILE 'C:\oraclexe\app\oracle\oradata\XE\SYSTEM.DBF' AUTOEXTEND ON NEXT 1000M;

alter database datafile 'C:\oraclexe\app\oracle\oradata\XE\SYSAUX.DBF' resize 2000m;

ALTER DATABASE DATAFILE 'C:\oraclexe\app\oracle\oradata\XE\SYSAUX.DBF' AUTOEXTEND ON NEXT 1000M;
```