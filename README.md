Skenario Uji Kustom (UI Test): Validasi Perubahan State Layar 1 ke Layar 2

Tujuan: Memastikan interaksi klik pengguna pada gambar "Lemon Tree" berhasil merender ulang UI (Recomposition) dengan teks instruksi dan gambar yang baru. Skenario ini memvalidasi bahwa state currentStep berhasil berubah dari 1 menjadi 2.

Langkah Uji:

Memastikan teks "Tap the lemon tree..." dan gambar dengan Content Description "Lemon Tree" muncul di layar awal.

Mensimulasikan performClick() pada elemen gambar pohon.

Memverifikasi menggunakan assertIsDisplayed() bahwa teks instruksi berubah menjadi "Keep tapping the lemon..." dan gambar berubah menjadi "Lemon".

Hasil Aktual: Pengujian berhasil (Passed) yang membuktikan alur navigasi dari step 1 ke step 2 berjalan sempurna.
(Jangan lupa sisipkan screenshot hasil running tes yang berwarna hijau di bawah teks ini).<img width="1917" height="1077" alt="image" src="https://github.com/user-attachments/assets/15419b85-e61f-4a03-93d7-38b94ca9bb7d" />
