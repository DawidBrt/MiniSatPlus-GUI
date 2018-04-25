#!/bin/bash
echo "This script is about to run another script."
sh ./MiniSat+/minisat+_script $1 > ans.txt
echo "This script has just run another script."
