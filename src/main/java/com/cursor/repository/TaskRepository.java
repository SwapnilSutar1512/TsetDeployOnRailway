package com.cursor.repository;
// हिंदी में उत्तर:
// TaskRepository इंटरफ़ेस बनाएँ और इसे JpaRepository से एक्सटेंड करें ताकि Task ऑपरेशन्स किए जा सकें।

import com.cursor.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    // यहाँ आप कस्टम क्वेरी मेथड्स भी जोड़ सकते हैं यदि ज़रूरत हो।
}
