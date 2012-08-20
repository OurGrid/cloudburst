cloudburst
==========

Launching Workers on the cloud.

Bundling a Worker image
=======================

sudo ec2-bundle-vol --prefix ubuntu-i386-ourgridworker-20120820 --user $USER_ID --arch i386 --destination /mnt --cert /tmp/cert-*.pem --privatekey /tmp/pk-*.pem --size 10240 --exclude /mnt,/tmp,/root/.ssh

sudo ec2-upload-bundle -b ourgrid-images -m /mnt/ubuntu-i386-ourgridworker-20120820.manifest.xml -a $ACCESS_KEY -s $SECRET_KEY

sudo ec2-register -C /tmp/cert-*.pem -K /tmp/pk-*.pem --name "ourgrid-images/ubuntu-i386-ourgridworker-20120820" ourgrid-images/ubuntu-i386-ourgridworker-20120820.manifest.xml

Output: IMAGE ami-1fed5976