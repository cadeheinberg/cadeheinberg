#!/bin/bash

echo "Content-type:text/json"
echo ""
java -cp ../JavaFiles/. GetUserInfo $QUERY_STRING