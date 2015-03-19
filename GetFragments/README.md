#Purpose
This tool will connect to pxf and dump the all the fragments returned by the HadoopCluster/getNodesInfo api call

#Usage

```
 [gpadmin@hdm1 ~]$ /usr/java/default/bin/java -classpath PXFGetFragments.jar:`hadoop classpath` io.pivotal.support.pxf.api.utilities.GetFragments /tmp/file.txt
 Setting up request params
 creating fragmenter
 getting fragments
 15/03/19 15:43:07 WARN util.NativeCodeLoader: Unable to load native-hadoop library for your platform... using builtin-java classes where applicable
 15/03/19 15:43:09 WARN hdfs.BlockReaderLocal: The short-circuit local reads feature cannot be used because libhadoop cannot be loaded.
 15/03/19 15:43:10 INFO hdfs.DFSClient: Created HDFS_DELEGATION_TOKEN token 5454 for gpadmin on ha-hdfs:elephant
 15/03/19 15:43:10 INFO security.TokenCache: Got dt for hdfs://elephant; Kind: HDFS_DELEGATION_TOKEN, Service: ha-hdfs:elephant, Ident: (HDFS_DELEGATION_TOKEN token 5454 for gpadmin)
 15/03/19 15:43:10 INFO mapred.FileInputFormat: Total input paths to process : 1
 dumping fragments
 {"PXFFragments":[{"userData":null,"replicas":["172.28.17.239","172.28.17.240","172.28.17.238"],"metadata":"rO0ABXcQAAAAAAAAAAAAAAAAAAABdHVyABNbTGphdmEubGFuZy5TdHJpbmc7rdJW5+kde0cCAAB4cAAAAAN0AA5oZHcyLnBoZC5sb2NhbHQADmhkdzMucGhkLmxvY2FsdAAOaGR3MS5waGQubG9jYWw=","sourceName":"/tmp/file.txt","index":0}]}

```

#Build

```
 Required JARs for build
 /var/gphd/pxf/pxf-service/webapps/pxf/WEB-INF/lib/pxf-api-2.3.0.0.jar
 /usr/lib/gphd/pxf/pxf-hdfs.jar
 /usr/lib/gphd/pxf/pxf-service.jar
 /usr/lib/gphd/pxf/pxf-plugin.jar
```
