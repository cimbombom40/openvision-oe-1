# Ubuntu 18.04.x LTS setup
* Run our https://github.com/OpenVisionE2/openvision-oe/blob/develop/ltsubuntu.sh

# How to get latest Ubuntu 18.04.x updates
```
sudo apt-get update
sudo apt-get install --install-recommends linux-generic-hwe-18.04 xserver-xorg-hwe-18.04
```
# How to use Xfce 4 desktop on Ubuntu
(as GNOME 3 wastes so many resources)

1- Disable wayland:
```
sudo gedit /etc/gdm3/custom.conf
```
(Change "#WaylandEnable=false" to "WaylandEnable=false")
```
sudo reboot
```
2- Install Xfce 4:
```
sudo apt-get install xfce4
```
