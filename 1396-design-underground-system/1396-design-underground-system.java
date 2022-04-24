class UndergroundSystem {
  
    HashMap<Integer, Person> personMap;

    HashMap<Pair<String, String>, Journey> journeyMap;

    public UndergroundSystem() {
        personMap = new HashMap();
        journeyMap = new HashMap();
    }
    
    public void checkIn(int id, String stationName, int t) {
        personMap.putIfAbsent(id, new Person());
        
        //update the checkTime, and start station 
        Person p = personMap.get(id);
        p.startTime = t;
        p.startStation = stationName;
    }
    
    public void checkOut(int id, String stationName, int t) {
        Person p = personMap.get(id);
        
        //get the journey, between start Station and current startion
        Journey journey = getJourney(p.startStation, stationName);
        
        //update travel duration, and travel count
        journey.totalTravelDuration += t - p.startTime;
        journey.totalTravelcount++;
    }
    
    public double getAverageTime(String startStation, String endStation) {
        Journey journey = getJourney(startStation, endStation);
        return (double) journey.totalTravelDuration / journey.totalTravelcount;
    }
    
    private Journey getJourney(String startStation, String endStation){
        
        Pair pair = new Pair(startStation, endStation);
  
        journeyMap.putIfAbsent(pair, new Journey());
        
        return journeyMap.get(pair);
    }
    
     
}

class Journey{
  
    int totalTravelDuration;
    int totalTravelcount;
    
    public Journey(){
        this.totalTravelDuration = 0;
        this.totalTravelcount = 0;
    }
}

class Person {
    String startStation;
    int startTime;
}