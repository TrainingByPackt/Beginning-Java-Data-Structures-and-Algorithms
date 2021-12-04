package com.packt.datastructuresandalg.lesson3.activity.project.bonus;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;
import com.packt.datastructuresandalg.lesson3.activity.project.MemberAccountNew;
import com.packt.datastructuresandalg.lesson3.activity.project.MemberDataNew;


public class SimilarVideoSolution {

	/**This method gets a video ID and member data and uses this data 
	 * to find similar videos to the given one. Returns a list containing
	 * all videos watched if this video is watched in decreasing order.
	 * 
	 * @param dataNew member database including watched videos by members in the past
	 * @param videoID current video ID, which will be used to find similar videos
	 * 
	 * @return a list containing all videos watched if this video is watched,
	 *  in decreasing order.
	 */
	public static ArrayList<Long> getSimilarVideos(MemberDataNew dataNew, Long videoID) {
		
		//define return array
		ArrayList<Long> videoList = new ArrayList<>();
		
		//define counter
		TreeMap<Long, VideoCounter> videoCounter = new TreeMap<>();
		
		//for each account
		for (Map.Entry<String, MemberAccountNew> entry : dataNew.getAccounts().entrySet()) {
			
			//get watched videos
			TreeMap<Long, Long> watchedList = entry.getValue().getWatchedList();
			
			//check if the video is watched by this member
			if (watchedList.containsKey(videoID)) {
				
				//count each watched video
				for (Map.Entry<Long, Long> videoEntry : watchedList.entrySet() ) {
					
					//get watched videoID
					long watchedVideoID = videoEntry.getValue();
					
					//check if it is other video
					if (watchedVideoID != videoID) {
						
						//search if it is added
						if (videoCounter.containsKey(watchedVideoID)) {
							videoCounter.get(watchedVideoID).count();
						} else { // if not 
							//first add the video and count
							videoCounter.put(watchedVideoID, new VideoCounter(watchedVideoID, 1));							
						}
					}
				}
			}
		}

		//define video counter list
		ArrayList<VideoCounter> videoCounterList = new ArrayList<>();
		
		//for each video
		for (Map.Entry<Long, VideoCounter> videoEntry : videoCounter.entrySet() ) {
			
			//add to video counter list
			videoCounterList.add(videoEntry.getValue());			
		}
		
		//sort video counter list by values
		Collections.sort(videoCounterList, Collections.reverseOrder());

		//generate return list
		for (int i = 0; i < videoCounterList.size(); i++) {
			videoList.add(videoCounterList.get(i).getVideoID());
		}
		
		return videoList;
	}

}
