#!/bin/bash
echo "This script is about to run another script."
ls
sh ./MiniSat+/minisat+_script $1 > Solution/ans.txt
echo "This script has just run another script."
